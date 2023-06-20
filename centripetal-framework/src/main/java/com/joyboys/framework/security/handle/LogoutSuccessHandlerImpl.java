package com.joyboys.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.joyboys.common.constant.Constants;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.domain.model.LoginUser;
import com.joyboys.common.utils.ServletUtils;
import com.joyboys.common.utils.StringUtils;
import com.joyboys.framework.manager.AsyncManager;
import com.joyboys.framework.manager.factory.AsyncFactory;
import com.joyboys.framework.web.service.TokenService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 自定义退出处理类 返回成功
 *
 * @author joyboys
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

  @Autowired
  private TokenService tokenService;

  /**
   * 退出处理
   *
   * @return
   */
  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication)
      throws IOException, ServletException {
    LoginUser loginUser = tokenService.getLoginUser(request);
    if (StringUtils.isNotNull(loginUser)) {
      String userName = loginUser.getUsername();
      // 删除用户缓存记录
      tokenService.delLoginUser(loginUser.getToken());
      // 记录用户退出日志
      AsyncManager.me()
          .execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
    }
    ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success("退出成功")));
  }
}
