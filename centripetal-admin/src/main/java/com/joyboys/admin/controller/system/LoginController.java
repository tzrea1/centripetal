package com.joyboys.admin.controller.system;

import com.joyboys.common.constant.Constants;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.domain.entity.User;
import com.joyboys.common.core.domain.model.LoginBody;
import com.joyboys.common.utils.SecurityUtils;
import com.joyboys.framework.web.service.SysLoginService;
import com.joyboys.framework.web.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录验证
 *
 * @author joyboys
 */
@RestController
@Api(tags = "LoginController", description = "登录验证")
public class LoginController {

  @Autowired
  private SysLoginService loginService;

  @Autowired
  private SysPermissionService permissionService;

  /**
   * 登录方法
   *
   * @param loginBody 登录信息
   * @return 结果
   */
  @ApiOperation(value = "登录方法")
  @PostMapping("/login")
  public AjaxResult login(@RequestBody LoginBody loginBody) {
    AjaxResult ajax = AjaxResult.success();
    // 生成令牌
    String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(),
        loginBody.getCode(),
        loginBody.getUuid());
    ajax.put(Constants.TOKEN, token);
    return ajax;
  }

  /**
   * 获取用户信息
   *
   * @return 用户信息
   */
  @ApiOperation(value = "获取用户信息")
  @GetMapping("getInfo")
  public AjaxResult getInfo() {
    User user = SecurityUtils.getLoginUser().getUser();
    // 角色集合
    Set<String> roles = permissionService.getRolePermission(user);
    AjaxResult ajax = AjaxResult.success();
    ajax.put("user", user);
    ajax.put("roles", roles);
    return ajax;
  }
}
