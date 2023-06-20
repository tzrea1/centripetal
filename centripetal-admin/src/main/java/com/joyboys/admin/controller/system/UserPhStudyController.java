package com.joyboys.admin.controller.system;

import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.page.TableDataInfo;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.system.domain.UserPhStudy;
import com.joyboys.system.service.IUserPhStudyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user用户参与党史内容学习的关系Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "UserPhStudyController", description = "user用户参与党史内容学习的关系Controller")
@RequestMapping("/system/content-rec")
public class UserPhStudyController extends BaseController {

  @Autowired
  private IUserPhStudyService userPhStudyService;

  /**
   * 查询user用户参与党史内容学习的关系列表
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:list')")
  @ApiOperation(value = "查询user用户参与党史内容学习的关系列表")
  @GetMapping("/list")
  public TableDataInfo list(UserPhStudy userPhStudy) {
    startPage();
    List<UserPhStudy> list = userPhStudyService.selectUserPhStudyList(userPhStudy);
    return getDataTable(list);
  }

  /**
   * 导出user用户参与党史内容学习的关系列表
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:export')")
  @Log(title = "user用户参与党史内容学习的关系", businessType = BusinessType.EXPORT)
  @ApiOperation(value = "导出user用户参与党史内容学习的关系列表")
  @PostMapping("/export")
  public void export(HttpServletResponse response, UserPhStudy userPhStudy) {
    List<UserPhStudy> list = userPhStudyService.selectUserPhStudyList(userPhStudy);
    ExcelUtil<UserPhStudy> util = new ExcelUtil<UserPhStudy>(UserPhStudy.class);
    util.exportExcel(response, list, "user用户参与党史内容学习的关系数据");
  }

  /**
   * 获取user用户参与党史内容学习的关系详细信息
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:query')")
  @ApiOperation(value = "获取user用户参与党史内容学习的关系详细信息")
  @GetMapping
  public AjaxResult getInfo(UserPhStudy userPhStudy) {
    return success(userPhStudyService.selectUserPhStudyByPhStudyId(userPhStudy));
  }

  /**
   * 新增user用户参与党史内容学习的关系
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:add')")
  @Log(title = "user用户参与党史内容学习的关系", businessType = BusinessType.INSERT)
  @ApiOperation(value = "新增user用户参与党史内容学习的关系")
  @PostMapping
  public AjaxResult add(@RequestBody UserPhStudy userPhStudy) {
    return toAjax(userPhStudyService.insertUserPhStudy(userPhStudy));
  }

  /**
   * 修改user用户参与党史内容学习的关系
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:edit')")
  @Log(title = "user用户参与党史内容学习的关系", businessType = BusinessType.UPDATE)
  @ApiOperation(value = "修改user用户参与党史内容学习的关系")
  @PutMapping
  public AjaxResult edit(@RequestBody UserPhStudy userPhStudy) {
    return toAjax(userPhStudyService.updateUserPhStudy(userPhStudy));
  }

  /**
   * 删除user用户参与党史内容学习的关系
   */
  @PreAuthorize("@ss.hasPermi('system:content-rec:remove')")
  @Log(title = "user用户参与党史内容学习的关系", businessType = BusinessType.DELETE)
  @ApiOperation(value = "删除user用户参与党史内容学习的关系")
  @DeleteMapping
  public AjaxResult remove(@RequestBody List<UserPhStudy> userPhStudy) {
    return toAjax(userPhStudyService.deleteUserPhStudyByPhStudyIds(userPhStudy));
  }
}
