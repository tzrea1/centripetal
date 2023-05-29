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
import com.joyboys.system.domain.Notice;
import com.joyboys.system.service.INoticeService;
import com.joyboys.common.utils.poi.ExcelUtil;
import com.joyboys.common.core.page.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 组内通知Controller
 * 
 * @author joyboys
 * @date 2023-05-08
 */
@RestController
@Api(tags = "NoticeController", description = "组内通知Controller")
@RequestMapping("/system/notice")
public class NoticeController extends BaseController
{
    @Autowired
    private INoticeService noticeService;

    /**
     * 查询组内通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notice:list')")
    @ApiOperation(value = "查询组内通知列表")
    @GetMapping("/list")
    public TableDataInfo list(Notice notice)
    {
        startPage();
        List<Notice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 导出组内通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notice:export')")
    @Log(title = "组内通知", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出组内通知列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Notice notice)
    {
        List<Notice> list = noticeService.selectNoticeList(notice);
        ExcelUtil<Notice> util = new ExcelUtil<Notice>(Notice.class);
        util.exportExcel(response, list, "组内通知数据");
    }

    /**
     * 获取组内通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notice:query')")
    @ApiOperation(value = "获取组内通知详细信息")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(noticeService.selectNoticeByNoticeId(noticeId));
    }

    /**
     * 新增组内通知
     */
    @PreAuthorize("@ss.hasPermi('system:notice:add')")
    @Log(title = "组内通知", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增组内通知")
    @PostMapping
    public AjaxResult add(@RequestBody Notice notice)
    {
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改组内通知
     */
    @PreAuthorize("@ss.hasPermi('system:notice:edit')")
    @Log(title = "组内通知", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改组内通知")
    @PutMapping
    public AjaxResult edit(@RequestBody Notice notice)
    {
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除组内通知
     */
    @PreAuthorize("@ss.hasPermi('system:notice:remove')")
    @Log(title = "组内通知", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除组内通知")
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(noticeService.deleteNoticeByNoticeIds(noticeIds));
    }
}
