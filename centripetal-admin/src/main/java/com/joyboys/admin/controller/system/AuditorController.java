package com.joyboys.admin.controller.system;

import com.joyboys.common.annotation.Log;
import com.joyboys.common.core.controller.BaseController;
import com.joyboys.common.core.domain.AjaxResult;
import com.joyboys.common.core.page.TableDataInfo;
import com.joyboys.common.enums.BusinessType;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.system.domain.Auditor;
import com.joyboys.system.service.IAuditorService;
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
 * 审核员实体Controller
 *
 * @author joyboys
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/system/auditor")
public class AuditorController extends BaseController {

  @Autowired
  private IAuditorService auditorService;

  /**
   * 查询审核员实体列表
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:list')")
  @GetMapping("/list")
  public TableDataInfo list(Auditor auditor) {
    startPage();
    List<Auditor> list = auditorService.selectAuditorList(auditor);
    return getDataTable(list);
  }

  /**
   * 导出审核员实体列表
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:export')")
  @Log(title = "审核员实体", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  public void export(HttpServletResponse response, Auditor auditor) {
    List<Auditor> list = auditorService.selectAuditorList(auditor);
    ExcelUtil<Auditor> util = new ExcelUtil<Auditor>(Auditor.class);
    util.exportExcel(response, list, "审核员实体数据");
  }

  /**
   * 获取审核员实体详细信息
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:query')")
  @GetMapping(value = "/{auditorId}")
  public AjaxResult getInfo(@PathVariable("auditorId") Long auditorId) {
    return success(auditorService.selectAuditorByAuditorId(auditorId));
  }

  /**
   * 新增审核员实体
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:add')")
  @Log(title = "审核员实体", businessType = BusinessType.INSERT)
  @PostMapping
  public AjaxResult add(@RequestBody Auditor auditor) {
    return toAjax(auditorService.insertAuditor(auditor));
  }

  /**
   * 修改审核员实体
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:edit')")
  @Log(title = "审核员实体", businessType = BusinessType.UPDATE)
  @PutMapping
  public AjaxResult edit(@RequestBody Auditor auditor) {
    return toAjax(auditorService.updateAuditor(auditor));
  }

  /**
   * 删除审核员实体
   */
  @PreAuthorize("@ss.hasPermi('system:auditor:remove')")
  @Log(title = "审核员实体", businessType = BusinessType.DELETE)
  @DeleteMapping("/{auditorIds}")
  public AjaxResult remove(@PathVariable Long[] auditorIds) {
    return toAjax(auditorService.deleteAuditorByAuditorIds(auditorIds));
  }
}
