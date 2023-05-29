package com.joyboys.admin.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.joyboys.system.domain.AuditorQuizAcitvity;
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
import com.joyboys.system.domain.AuditorPhStudy;
import com.joyboys.system.service.IAuditorPhStudyService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 审核员审核党史内容学习的记录Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "AuditorPhStudyController", description = "审核员审核党史内容学习的记录Controller")
@RequestMapping("/system/content-adt")
public class AuditorPhStudyController extends BaseController
{
    @Autowired
    private IAuditorPhStudyService auditorPhStudyService;

    /**
     * 查询审核员审核党史内容学习的记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:list')")
    @ApiOperation(value = "查询审核员审核党史内容学习的记录列表")
    @GetMapping("/list")
    public TableDataInfo list(AuditorPhStudy auditorPhStudy)
    {
        startPage();
        List<AuditorPhStudy> list = auditorPhStudyService.selectAuditorPhStudyList(auditorPhStudy);
        return getDataTable(list);
    }

    /**
     * 导出审核员审核党史内容学习的记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:export')")
    @Log(title = "审核员审核党史内容学习的记录", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出审核员审核党史内容学习的记录列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, AuditorPhStudy auditorPhStudy)
    {
        List<AuditorPhStudy> list = auditorPhStudyService.selectAuditorPhStudyList(auditorPhStudy);
        ExcelUtil<AuditorPhStudy> util = new ExcelUtil<AuditorPhStudy>(AuditorPhStudy.class);
        util.exportExcel(response, list, "审核员审核党史内容学习的记录数据");
    }

    /**
     * 获取审核员审核党史内容学习的记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:query')")
    @ApiOperation(value = "获取审核员审核党史内容学习的记录详细信息")
    @GetMapping
    public AjaxResult getInfo(AuditorPhStudy auditorPhStudy)
    {
        return success(auditorPhStudyService.selectAuditorPhStudyByAuditorId(auditorPhStudy));
    }

    /**
     * 新增审核员审核党史内容学习的记录
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:add')")
    @Log(title = "审核员审核党史内容学习的记录", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增审核员审核党史内容学习的记录")
    @PostMapping
    public AjaxResult add(@RequestBody AuditorPhStudy auditorPhStudy)
    {
        return toAjax(auditorPhStudyService.insertAuditorPhStudy(auditorPhStudy));
    }

    /**
     * 修改审核员审核党史内容学习的记录
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:edit')")
    @Log(title = "审核员审核党史内容学习的记录", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改审核员审核党史内容学习的记录")
    @PutMapping
    public AjaxResult edit(@RequestBody AuditorPhStudy auditorPhStudy)
    {
        return toAjax(auditorPhStudyService.updateAuditorPhStudy(auditorPhStudy));
    }

    /**
     * 删除审核员审核党史内容学习的记录
     */
    @PreAuthorize("@ss.hasPermi('system:content-adt:remove')")
    @Log(title = "审核员审核党史内容学习的记录", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除审核员审核党史内容学习的记录")
    @DeleteMapping
    public AjaxResult remove(@RequestBody List<AuditorPhStudy> auditorPhStudy)
    {
        return toAjax(auditorPhStudyService.deleteAuditorPhStudyByAuditorIds(auditorPhStudy));
    }
}
