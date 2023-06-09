package com.joyboys.framework.web.service;

import com.joyboys.common.constant.CacheConstants;
import com.joyboys.common.constant.Constants;
import com.joyboys.common.constant.UserConstants;
import com.joyboys.common.core.domain.model.LoginUser;
import com.joyboys.common.core.redis.RedisCache;
import com.joyboys.common.exception.ServiceException;
import com.joyboys.common.exception.user.BlackListException;
import com.joyboys.common.exception.user.CaptchaException;
import com.joyboys.common.exception.user.CaptchaExpireException;
import com.joyboys.common.exception.user.UserNotExistsException;
import com.joyboys.common.exception.user.UserPasswordNotMatchException;
import com.joyboys.common.utils.MessageUtils;
import com.joyboys.common.utils.StringUtils;
import com.joyboys.common.utils.ip.IpUtils;
import com.joyboys.framework.manager.AsyncManager;
import com.joyboys.framework.manager.factory.AsyncFactory;
import com.joyboys.framework.security.context.AuthenticationContextHolder;
import com.joyboys.system.service.ISysConfigService;
import com.joyboys.system.service.IUserService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 登录校验方法
 *
 * @author joyboys
 */
@Component
public class SysLoginService {

  @Autowired
  private TokenService tokenService;

  @Resource
  private AuthenticationManager authenticationManager;

  @Autowired
  private RedisCache redisCache;

  @Autowired
  private IUserService userService;

  @Autowired
  private ISysConfigService configService;

  /**
   * 登录验证
   *
   * @param username 用户名
   * @param password 密码
   * @param code     验证码
   * @param uuid     唯一标识
   * @return 结果
   */
  public String login(String username, String password, String code, String uuid) {
    // 如果用户名为"admin"，直接返回，不进行验证码校验
    if (!"admin".equals(username)) {
      // 验证码校验
      validateCaptcha(username, code, uuid);
    }
    // 登录前置校验
    loginPreCheck(username, password);
    // 用户验证
    Authentication authentication = null;
    try {
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
          username, password);
      AuthenticationContextHolder.setContext(authenticationToken);
      // 调用UserDetailsServiceImpl.loadUserByUsername
      authentication = authenticationManager.authenticate(authenticationToken);
    } catch (Exception e) {
      if (e instanceof BadCredentialsException) {
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
            MessageUtils.message("user.password.not.match")));
        throw new UserPasswordNotMatchException();
      } else {
        AsyncManager.me()
            .execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
        throw new ServiceException(e.getMessage());
      }
    } finally {
      AuthenticationContextHolder.clearContext();
    }
    AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS,
        MessageUtils.message("user.login.success")));
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
    // recordLoginInfo(loginUser.getUserId());
    // 生成token
    return tokenService.createToken(loginUser);
  }

  /**
   * 校验验证码
   *
   * @param username 用户名
   * @param code     验证码
   * @param uuid     唯一标识
   * @return 结果
   */
  public void validateCaptcha(String username, String code, String uuid) {

    boolean captchaEnabled = configService.selectCaptchaEnabled();
    if (captchaEnabled) {
      String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
      String captcha = redisCache.getCacheObject(verifyKey);
      redisCache.deleteObject(verifyKey);
      if (captcha == null) {
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
            MessageUtils.message("user.jcaptcha.expire")));
        throw new CaptchaExpireException();
      }
      if (!code.equalsIgnoreCase(captcha)) {
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
            MessageUtils.message("user.jcaptcha.error")));
        throw new CaptchaException();
      }
    }
  }

  /**
   * 登录前置校验
   *
   * @param username 用户名
   * @param password 用户密码
   */
  public void loginPreCheck(String username, String password) {
    // 用户名或密码为空 错误
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
          MessageUtils.message("not.null")));
      throw new UserNotExistsException();
    }
    // 密码如果不在指定范围内 错误
    if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
        || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
          MessageUtils.message("user.password.not.match")));
      throw new UserPasswordNotMatchException();
    }
    // 用户名不在指定范围内 错误
    if (username.length() < UserConstants.USERNAME_MIN_LENGTH
        || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
          MessageUtils.message("user.password.not.match")));
      throw new UserPasswordNotMatchException();
    }
    // IP黑名单校验
    String blackStr = configService.selectConfigByKey("sys.login.blackIPList");
    if (IpUtils.isMatchedIp(blackStr, IpUtils.getIpAddr())) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
          MessageUtils.message("login.blocked")));
      throw new BlackListException();
    }
  }
}
