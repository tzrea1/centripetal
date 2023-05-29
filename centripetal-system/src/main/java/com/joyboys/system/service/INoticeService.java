package com.joyboys.system.service;

import java.util.List;
import com.joyboys.system.domain.Notice;

/**
 * 组内通知Service接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface INoticeService 
{
    /**
     * 查询组内通知
     * 
     * @param noticeId 组内通知主键
     * @return 组内通知
     */
    public Notice selectNoticeByNoticeId(Long noticeId);

    /**
     * 查询组内通知列表
     * 
     * @param notice 组内通知
     * @return 组内通知集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增组内通知
     * 
     * @param notice 组内通知
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改组内通知
     * 
     * @param notice 组内通知
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 批量删除组内通知
     * 
     * @param noticeIds 需要删除的组内通知主键集合
     * @return 结果
     */
    public int deleteNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除组内通知信息
     * 
     * @param noticeId 组内通知主键
     * @return 结果
     */
    public int deleteNoticeByNoticeId(Long noticeId);
}
