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
import com.joyboys.system.domain.AuditorQuizAcitvity;
import com.joyboys.system.service.IAuditorQuizAcitvityService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 审核员审核答题活动的记录Controller
 *
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "AuditorQuizAcitvityController", description = "审核员审核答题活动的记录Controller")
@RequestMapping("/system/contest-adt")
public class AuditorQuizAcitvityController extends BaseController
{
    @Autowired
    private IAuditorQuizAcitvityService auditorQuizAcitvityService;

    /**
     * 查询审核员审核答题活动的记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:list')")
    @ApiOperation(value = "查询审核员审核答题活动的记录列表")
    @GetMapping("/list")
    public TableDataInfo list(AuditorQuizAcitvity auditorQuizAcitvity)
    {
        startPage();
        List<AuditorQuizAcitvity> list = auditorQuizAcitvityService.selectAuditorQuizAcitvityList(auditorQuizAcitvity);
        return getDataTable(list);
    }

    /**
     * 导出审核员审核答题活动的记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:export')")
    @Log(title = "审核员审核答题活动的记录", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出审核员审核答题活动的记录列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, AuditorQuizAcitvity auditorQuizAcitvity)
    {
        List<AuditorQuizAcitvity> list = auditorQuizAcitvityService.selectAuditorQuizAcitvityList(auditorQuizAcitvity);
        ExcelUtil<AuditorQuizAcitvity> util = new ExcelUtil<AuditorQuizAcitvity>(AuditorQuizAcitvity.class);
        util.exportExcel(response, list, "审核员审核答题活动的记录数据");
    }

    /**
     * 获取审核员审核答题活动的记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:query')")
    @ApiOperation(value = "获取审核员审核答题活动的记录详细信息")
    @GetMapping
    public AjaxResult getInfo(AuditorQuizAcitvity auditorQuizAcitvity)
    {
        return success(auditorQuizAcitvityService.selectAuditorQuizAcitvityByAuditorId(auditorQuizAcitvity));
    }

    /**
     * 新增审核员审核答题活动的记录
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:add')")
    @Log(title = "审核员审核答题活动的记录", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增审核员审核答题活动的记录")
    @PostMapping
    public AjaxResult add(@RequestBody AuditorQuizAcitvity auditorQuizAcitvity)
    {
        return toAjax(auditorQuizAcitvityService.insertAuditorQuizAcitvity(auditorQuizAcitvity));
    }

    /**
     * 修改审核员审核答题活动的记录
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:edit')")
    @Log(title = "审核员审核答题活动的记录", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改审核员审核答题活动的记录")
    @PutMapping
    public AjaxResult edit(@RequestBody AuditorQuizAcitvity auditorQuizAcitvity)
    {
        return toAjax(auditorQuizAcitvityService.updateAuditorQuizAcitvity(auditorQuizAcitvity));
    }

    /**
     * 删除审核员审核答题活动的记录
     */
    @PreAuthorize("@ss.hasPermi('system:contest-adt:remove')")
    @Log(title = "审核员审核答题活动的记录", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除审核员审核答题活动的记录")
    @DeleteMapping
    public AjaxResult remove(@RequestBody List<AuditorQuizAcitvity> auditorQuizAcitvities)
    {
        return toAjax(auditorQuizAcitvityService.deleteAuditorQuizAcitvityByAuditorIds(auditorQuizAcitvities));
    }
}
