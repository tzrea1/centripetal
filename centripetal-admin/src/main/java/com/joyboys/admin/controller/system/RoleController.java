package com.joyboys.admin.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.core.domain.entity.Role;
import com.joyboys.system.service.IRoleService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

/**
 * 权限角色，包括普通用户user，管理员leader，组长headmanController
 * 
 * @author joyboys
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController
{
    @Autowired
    private IRoleService roleService;

    /**
     * 查询权限角色，包括普通用户user，管理员leader，组长headman列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:list')")
    @GetMapping("/list")
    public TableDataInfo list(Role role)
    {
        startPage();
        List<Role> list = roleService.selectRoleList(role);
        return getDataTable(list);
    }

    /**
     * 导出权限角色，包括普通用户user，管理员leader，组长headman列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:export')")
    @Log(title = "权限角色，包括普通用户user，管理员leader，组长headman", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Role role)
    {
        List<Role> list = roleService.selectRoleList(role);
        ExcelUtil<Role> util = new ExcelUtil<Role>(Role.class);
        util.exportExcel(response, list, "权限角色，包括普通用户user，管理员leader，组长headman数据");
    }

    /**
     * 获取权限角色，包括普通用户user，管理员leader，组长headman详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return success(roleService.selectRoleById(roleId));
    }

    /**
     * 新增权限角色，包括普通用户user，管理员leader，组长headman
     */
    @PreAuthorize("@ss.hasPermi('system:role:add')")
    @Log(title = "权限角色，包括普通用户user，管理员leader，组长headman", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Role role)
    {
        return toAjax(roleService.insertRole(role));
    }

    /**
     * 修改权限角色，包括普通用户user，管理员leader，组长headman
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "权限角色，包括普通用户user，管理员leader，组长headman", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Role role)
    {
        return toAjax(roleService.updateRole(role));
    }

    /**
     * 删除权限角色，包括普通用户user，管理员leader，组长headman
     */
    @PreAuthorize("@ss.hasPermi('system:role:remove')")
    @Log(title = "权限角色，包括普通用户user，管理员leader，组长headman", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(roleService.deleteRoleByIds(roleIds));
    }
}
