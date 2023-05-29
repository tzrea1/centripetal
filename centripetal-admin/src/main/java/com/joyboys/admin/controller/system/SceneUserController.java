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
import com.joyboys.system.domain.SceneUser;
import com.joyboys.system.service.ISceneUserService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

/**
 * 用户虚拟场景间体验关系Controller
 * 
 * @author joyboys
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/system/scene-user")
public class SceneUserController extends BaseController
{
    @Autowired
    private ISceneUserService sceneUserService;

    /**
     * 查询用户虚拟场景间体验关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SceneUser sceneUser)
    {
        startPage();
        List<SceneUser> list = sceneUserService.selectSceneUserList(sceneUser);
        return getDataTable(list);
    }

    /**
     * 导出用户虚拟场景间体验关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @Log(title = "用户虚拟场景间体验关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SceneUser sceneUser)
    {
        List<SceneUser> list = sceneUserService.selectSceneUserList(sceneUser);
        ExcelUtil<SceneUser> util = new ExcelUtil<SceneUser>(SceneUser.class);
        util.exportExcel(response, list, "用户虚拟场景间体验关系数据");
    }

    /**
     * 获取用户虚拟场景间体验关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(sceneUserService.selectSceneUserByUserId(userId));
    }

    /**
     * 新增用户虚拟场景间体验关系
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "用户虚拟场景间体验关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SceneUser sceneUser)
    {
        return toAjax(sceneUserService.insertSceneUser(sceneUser));
    }

    /**
     * 修改用户虚拟场景间体验关系
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户虚拟场景间体验关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SceneUser sceneUser)
    {
        return toAjax(sceneUserService.updateSceneUser(sceneUser));
    }

    /**
     * 删除用户虚拟场景间体验关系
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "用户虚拟场景间体验关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(sceneUserService.deleteSceneUserByUserIds(userIds));
    }
}
