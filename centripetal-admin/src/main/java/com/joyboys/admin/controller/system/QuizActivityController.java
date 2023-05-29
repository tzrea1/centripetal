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
import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.service.IQuizActivityService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 答题活动Controller
 * 
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "QuizActivityController", description = "答题活动Controller")
@RequestMapping("/system/contest")
public class QuizActivityController extends BaseController
{
    @Autowired
    private IQuizActivityService quizActivityService;

    /**
     * 查询答题活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:contest:list')")
    @ApiOperation(value = "查询答题活动列表")
    @GetMapping("/list")
    public TableDataInfo list(QuizActivity quizActivity)
    {
        startPage();
        List<QuizActivity> list = quizActivityService.selectQuizActivityList(quizActivity);
        return getDataTable(list);
    }

    /**
     * 导出答题活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:contest:export')")
    @Log(title = "答题活动", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出答题活动列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, QuizActivity quizActivity)
    {
        List<QuizActivity> list = quizActivityService.selectQuizActivityList(quizActivity);
        ExcelUtil<QuizActivity> util = new ExcelUtil<QuizActivity>(QuizActivity.class);
        util.exportExcel(response, list, "答题活动数据");
    }

    /**
     * 获取答题活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contest:query')")
    @ApiOperation(value = "获取答题活动详细信息")
    @GetMapping(value = "/{quizActivityId}")
    public AjaxResult getInfo(@PathVariable("quizActivityId") Long quizActivityId)
    {
        return success(quizActivityService.selectQuizActivityByQuizActivityId(quizActivityId));
    }

    /**
     * 新增答题活动
     */
    @PreAuthorize("@ss.hasPermi('system:contest:add')")
    @Log(title = "答题活动", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增答题活动")
    @PostMapping
    public AjaxResult add(@RequestBody QuizActivity quizActivity)
    {
        return toAjax(quizActivityService.insertQuizActivity(quizActivity));
    }

    /**
     * 修改答题活动
     */
    @PreAuthorize("@ss.hasPermi('system:contest:edit')")
    @Log(title = "答题活动", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改答题活动")
    @PutMapping
    public AjaxResult edit(@RequestBody QuizActivity quizActivity)
    {
        return toAjax(quizActivityService.updateQuizActivity(quizActivity));
    }

    /**
     * 删除答题活动
     */
    @PreAuthorize("@ss.hasPermi('system:contest:remove')")
    @Log(title = "答题活动", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除答题活动")
	@DeleteMapping("/{quizActivityIds}")
    public AjaxResult remove(@PathVariable Long[] quizActivityIds)
    {
        return toAjax(quizActivityService.deleteQuizActivityByQuizActivityIds(quizActivityIds));
    }
}
