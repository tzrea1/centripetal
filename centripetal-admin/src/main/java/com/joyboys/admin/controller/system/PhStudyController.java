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
import com.joyboys.system.domain.PhStudy;
import com.joyboys.system.service.IPhStudyService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 党史内容学习活动Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "PhStudyController", description = "党史内容学习活动Controller")
@RequestMapping("/system/content")
public class PhStudyController extends BaseController
{
    @Autowired
    private IPhStudyService phStudyService;

    /**
     * 查询党史内容学习活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:content:list')")
    @ApiOperation(value = "查询党史内容学习活动列表")
    @GetMapping("/list")
    public TableDataInfo list(PhStudy phStudy)
    {
        startPage();
        List<PhStudy> list = phStudyService.selectPhStudyList(phStudy);
        return getDataTable(list);
    }

    /**
     * 导出党史内容学习活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:content:export')")
    @Log(title = "党史内容学习活动", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出党史内容学习活动列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, PhStudy phStudy)
    {
        List<PhStudy> list = phStudyService.selectPhStudyList(phStudy);
        ExcelUtil<PhStudy> util = new ExcelUtil<PhStudy>(PhStudy.class);
        util.exportExcel(response, list, "党史内容学习活动数据");
    }

    /**
     * 获取党史内容学习活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:content:query')")
    @ApiOperation(value = "获取党史内容学习活动详细信息")
    @GetMapping(value = "/{phStudyId}")
    public AjaxResult getInfo(@PathVariable("phStudyId") Long phStudyId)
    {
        return success(phStudyService.selectPhStudyByPhStudyId(phStudyId));
    }

    /**
     * 新增党史内容学习活动
     */
    @PreAuthorize("@ss.hasPermi('system:content:add')")
    @Log(title = "党史内容学习活动", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增党史内容学习活动")
    @PostMapping
    public AjaxResult add(@RequestBody PhStudy phStudy)
    {
        return toAjax(phStudyService.insertPhStudy(phStudy));
    }

    /**
     * 修改党史内容学习活动
     */
    @PreAuthorize("@ss.hasPermi('system:content:edit')")
    @Log(title = "党史内容学习活动", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改党史内容学习活动")
    @PutMapping
    public AjaxResult edit(@RequestBody PhStudy phStudy)
    {
        return toAjax(phStudyService.updatePhStudy(phStudy));
    }

    /**
     * 删除党史内容学习活动
     */
    @PreAuthorize("@ss.hasPermi('system:content:remove')")
    @Log(title = "党史内容学习活动", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除党史内容学习活动")
    @DeleteMapping("/{phStudyIds}")
    public AjaxResult remove(@PathVariable Long[] phStudyIds)
    {
        return toAjax(phStudyService.deletePhStudyByPhStudyIds(phStudyIds));
    }
}
