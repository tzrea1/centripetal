package com.joyboys.admin.controller.system;

import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.page.TableDataInfo;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.system.domain.Group;
import com.joyboys.system.service.IGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小组Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "GroupController", description = "小组Controller")
@RequestMapping("/system/group")
public class GroupController extends BaseController {

  @Autowired
  private IGroupService groupService;

  /**
   * 查询小组列表
   */
  @PreAuthorize("@ss.hasPermi('system:group:list')")
  @ApiOperation(value = "查询小组列表")
  @GetMapping("/list")
  public TableDataInfo list(Group group) {
    startPage();
    List<Group> list = groupService.selectGroupList(group);
    return getDataTable(list);
  }

  /**
   * 导出小组列表
   */
  @PreAuthorize("@ss.hasPermi('system:group:export')")
  @Log(title = "小组", businessType = BusinessType.EXPORT)
  @ApiOperation(value = "导出小组列表")
  @PostMapping("/export")
  public void export(HttpServletResponse response, Group group) {
    List<Group> list = groupService.selectGroupList(group);
    ExcelUtil<Group> util = new ExcelUtil<Group>(Group.class);
    util.exportExcel(response, list, "小组数据");
  }

  /**
   * 获取小组详细信息
   */
  @PreAuthorize("@ss.hasPermi('system:group:query')")
  @ApiOperation(value = "获取小组详细信息")
  @GetMapping(value = "/{groupId}")
  public AjaxResult getInfo(@PathVariable("groupId") Long groupId) {
    return success(groupService.selectGroupByGroupId(groupId));
  }

  /**
   * 新增小组
   */
  @PreAuthorize("@ss.hasPermi('system:group:add')")
  @Log(title = "小组", businessType = BusinessType.INSERT)
  @ApiOperation(value = "新增小组")
  @PostMapping
  public AjaxResult add(@RequestBody Group group) {
    return toAjax(groupService.insertGroup(group));
  }

  /**
   * 修改小组
   */
  @PreAuthorize("@ss.hasPermi('system:group:edit')")
  @Log(title = "小组", businessType = BusinessType.UPDATE)
  @ApiOperation(value = "修改小组")
  @PutMapping
  public AjaxResult edit(@RequestBody Group group) {
    return toAjax(groupService.updateGroup(group));
  }

  /**
   * 删除小组
   */
  @PreAuthorize("@ss.hasPermi('system:group:remove')")
  @Log(title = "小组", businessType = BusinessType.DELETE)
  @ApiOperation(value = "删除小组")
  @DeleteMapping("/{groupIds}")
  public AjaxResult remove(@PathVariable Long[] groupIds) {
    return toAjax(groupService.deleteGroupByGroupIds(groupIds));
  }
}
