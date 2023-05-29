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
import com.joyboys.system.domain.SceneFile;
import com.joyboys.system.service.ISceneFileService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

/**
 * 虚拟场景相关文件Controller
 * 
 * @author joyboys
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/system/scene-file")
public class SceneFileController extends BaseController
{
    @Autowired
    private ISceneFileService sceneFileService;

    /**
     * 查询虚拟场景相关文件列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(SceneFile sceneFile)
    {
        startPage();
        List<SceneFile> list = sceneFileService.selectSceneFileList(sceneFile);
        return getDataTable(list);
    }

    /**
     * 导出虚拟场景相关文件列表
     */
    @PreAuthorize("@ss.hasPermi('system:file:export')")
    @Log(title = "虚拟场景相关文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SceneFile sceneFile)
    {
        List<SceneFile> list = sceneFileService.selectSceneFileList(sceneFile);
        ExcelUtil<SceneFile> util = new ExcelUtil<SceneFile>(SceneFile.class);
        util.exportExcel(response, list, "虚拟场景相关文件数据");
    }

    /**
     * 获取虚拟场景相关文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:file:query')")
    @GetMapping(value = "/{scenefileId}")
    public AjaxResult getInfo(@PathVariable("scenefileId") Long scenefileId)
    {
        return success(sceneFileService.selectSceneFileByScenefileId(scenefileId));
    }

    /**
     * 新增虚拟场景相关文件
     */
    @PreAuthorize("@ss.hasPermi('system:file:add')")
    @Log(title = "虚拟场景相关文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SceneFile sceneFile)
    {
        return toAjax(sceneFileService.insertSceneFile(sceneFile));
    }

    /**
     * 修改虚拟场景相关文件
     */
    @PreAuthorize("@ss.hasPermi('system:file:edit')")
    @Log(title = "虚拟场景相关文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SceneFile sceneFile)
    {
        return toAjax(sceneFileService.updateSceneFile(sceneFile));
    }

    /**
     * 删除虚拟场景相关文件
     */
    @PreAuthorize("@ss.hasPermi('system:file:remove')")
    @Log(title = "虚拟场景相关文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scenefileIds}")
    public AjaxResult remove(@PathVariable Long[] scenefileIds)
    {
        return toAjax(sceneFileService.deleteSceneFileByScenefileIds(scenefileIds));
    }
}
