package com.joyboys.admin.controller.system;

import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.page.TableDataInfo;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.system.domain.UserQuizActivity;
import com.joyboys.system.service.IUserQuizActivityService;
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
 * user用户参与答题活动的关系Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "UserQuizActivityController", description = "user用户参与答题活动的关系Controller")
@RequestMapping("/system/contest-rec")
public class UserQuizActivityController extends BaseController {

  @Autowired
  private IUserQuizActivityService userQuizActivityService;

  /**
   * 查询user用户参与答题活动的关系列表
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:list')")
  @ApiOperation(value = "查询user用户参与答题活动的关系列表")
  @GetMapping("/list")
  public TableDataInfo list(UserQuizActivity userQuizActivity) {
    startPage();
    List<UserQuizActivity> list = userQuizActivityService.selectUserQuizActivityList(
        userQuizActivity);
    return getDataTable(list);
  }

  /**
   * 导出user用户参与答题活动的关系列表
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:export')")
  @Log(title = "user用户参与答题活动的关系", businessType = BusinessType.EXPORT)
  @ApiOperation(value = "导出user用户参与答题活动的关系列表")
  @PostMapping("/export")
  public void export(HttpServletResponse response, UserQuizActivity userQuizActivity) {
    List<UserQuizActivity> list = userQuizActivityService.selectUserQuizActivityList(
        userQuizActivity);
    ExcelUtil<UserQuizActivity> util = new ExcelUtil<UserQuizActivity>(UserQuizActivity.class);
    util.exportExcel(response, list, "user用户参与答题活动的关系数据");
  }

  /**
   * 获取user用户参与答题活动的关系详细信息
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:query')")
  @ApiOperation(value = "获取user用户参与答题活动的关系详细信息")
  @GetMapping
  public AjaxResult getInfo(UserQuizActivity userQuizActivity) {
    return success(userQuizActivityService.selectUserQuizActivityByUserId(userQuizActivity));
  }

  /**
   * 新增user用户参与答题活动的关系
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:add')")
  @Log(title = "user用户参与答题活动的关系", businessType = BusinessType.INSERT)
  @ApiOperation(value = "新增user用户参与答题活动的关系")
  @PostMapping
  public AjaxResult add(@RequestBody UserQuizActivity userQuizActivity) {
    return toAjax(userQuizActivityService.insertUserQuizActivity(userQuizActivity));
  }

  /**
   * 修改user用户参与答题活动的关系
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:edit')")
  @Log(title = "user用户参与答题活动的关系", businessType = BusinessType.UPDATE)
  @ApiOperation(value = "修改user用户参与答题活动的关系")
  @PutMapping
  public AjaxResult edit(@RequestBody UserQuizActivity userQuizActivity) {
    return toAjax(userQuizActivityService.updateUserQuizActivity(userQuizActivity));
  }

  /**
   * 删除user用户参与答题活动的关系
   */
  @PreAuthorize("@ss.hasPermi('system:contest-rec:remove')")
  @Log(title = "user用户参与答题活动的关系", businessType = BusinessType.DELETE)
  @ApiOperation(value = "删除user用户参与答题活动的关系")
  @DeleteMapping
  public AjaxResult remove(@RequestBody List<UserQuizActivity> userQuizActivity) {
    return toAjax(userQuizActivityService.deleteUserQuizActivityByUserIds(userQuizActivity));
  }
}
