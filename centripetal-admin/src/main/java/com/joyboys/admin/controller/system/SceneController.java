package com.joyboys.admin.controller.system;

import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.page.TableDataInfo;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.system.domain.Scene;
import com.joyboys.system.service.ISceneService;
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
 * 虚拟场景Controller
 *
 * @author joyboys
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/system/scene")
public class SceneController extends BaseController {

  @Autowired
  private ISceneService sceneService;

  /**
   * 查询虚拟场景列表
   */
  @PreAuthorize("@ss.hasPermi('system:scene:list')")
  @GetMapping("/list")
  public TableDataInfo list(Scene scene) {
    startPage();
    List<Scene> list = sceneService.selectSceneList(scene);
    return getDataTable(list);
  }

  /**
   * 导出虚拟场景列表
   */
  @PreAuthorize("@ss.hasPermi('system:scene:export')")
  @Log(title = "虚拟场景", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  public void export(HttpServletResponse response, Scene scene) {
    List<Scene> list = sceneService.selectSceneList(scene);
    ExcelUtil<Scene> util = new ExcelUtil<Scene>(Scene.class);
    util.exportExcel(response, list, "虚拟场景数据");
  }

  /**
   * 获取虚拟场景详细信息
   */
  @PreAuthorize("@ss.hasPermi('system:scene:query')")
  @GetMapping(value = "/{sceneId}")
  public AjaxResult getInfo(@PathVariable("sceneId") Long sceneId) {
    return success(sceneService.selectSceneBySceneId(sceneId));
  }

  /**
   * 新增虚拟场景
   */
  @PreAuthorize("@ss.hasPermi('system:scene:add')")
  @Log(title = "虚拟场景", businessType = BusinessType.INSERT)
  @PostMapping
  public AjaxResult add(@RequestBody Scene scene) {
    return toAjax(sceneService.insertScene(scene));
  }

  /**
   * 修改虚拟场景
   */
  @PreAuthorize("@ss.hasPermi('system:scene:edit')")
  @Log(title = "虚拟场景", businessType = BusinessType.UPDATE)
  @PutMapping
  public AjaxResult edit(@RequestBody Scene scene) {
    return toAjax(sceneService.updateScene(scene));
  }

  /**
   * 删除虚拟场景
   */
  @PreAuthorize("@ss.hasPermi('system:scene:remove')")
  @Log(title = "虚拟场景", businessType = BusinessType.DELETE)
  @DeleteMapping("/{sceneIds}")
  public AjaxResult remove(@PathVariable Long[] sceneIds) {
    return toAjax(sceneService.deleteSceneBySceneIds(sceneIds));
  }
}
