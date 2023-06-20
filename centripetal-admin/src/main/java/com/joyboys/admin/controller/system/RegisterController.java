package com.joyboys.admin.controller.system;

import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.domain.model.RegisterBody;
import com.joyboys.common.utils.StringUtils;
import com.joyboys.framework.web.service.SysRegisterService;
import com.joyboys.system.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 *
 * @author joyboys
 */
@RestController
@Api(tags = "RegisterController", description = "注册验证")
public class RegisterController extends BaseController {

  @Autowired
  private SysRegisterService registerService;

  @Autowired
  private ISysConfigService configService;

  @ApiOperation(value = "注册接口")
  @PostMapping("/register")
  public AjaxResult register(@RequestBody RegisterBody user) {
    if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
      return error("当前系统没有开启注册功能！");
    }
    String msg = registerService.register(user);
    return StringUtils.isEmpty(msg) ? success() : error(msg);
  }
}
