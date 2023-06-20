package com.joyboys.admin.controller.framework;

import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.framework.web.dto.OssCallbackResult;
import com.joyboys.framework.web.dto.OssPolicyResult;
import com.joyboys.framework.web.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Oss相关操作接口 Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {

  @Autowired
  private OssServiceImpl ossService;

  @ApiOperation(value = "oss上传签名生成")
  @RequestMapping(value = "/policy", method = RequestMethod.GET)
  public AjaxResult policy() {
    OssPolicyResult result = ossService.policy();
    return AjaxResult.success(result);
  }

  @ApiOperation(value = "oss上传成功回调")
  @RequestMapping(value = "callback", method = RequestMethod.POST)
  public AjaxResult callback(HttpServletRequest request) {
    OssCallbackResult ossCallbackResult = ossService.callback(request);
    return AjaxResult.success(ossCallbackResult);
  }

}

