package com.joyboys.system.service.impl;

import com.joyboys.system.domain.Notice;
import com.joyboys.system.mapper.NoticeMapper;
import com.joyboys.system.service.INoticeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 组内通知Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class NoticeServiceImpl implements INoticeService {

  @Autowired
  private NoticeMapper noticeMapper;

  /**
   * 查询组内通知
   *
   * @param noticeId 组内通知主键
   * @return 组内通知
   */
  @Override
  public Notice selectNoticeByNoticeId(Long noticeId) {
    return noticeMapper.selectNoticeByNoticeId(noticeId);
  }

  /**
   * 查询组内通知列表
   *
   * @param notice 组内通知
   * @return 组内通知
   */
  @Override
  public List<Notice> selectNoticeList(Notice notice) {
    return noticeMapper.selectNoticeList(notice);
  }

  /**
   * 新增组内通知
   *
   * @param notice 组内通知
   * @return 结果
   */
  @Override
  public int insertNotice(Notice notice) {
    if(notice.isValid()){
      return noticeMapper.insertNotice(notice);
    }
    else{
      return -1;
    }
  }

  /**
   * 修改组内通知
   *
   * @param notice 组内通知
   * @return 结果
   */
  @Override
  public int updateNotice(Notice notice) {
    if(notice.isValid()){
      return noticeMapper.updateNotice(notice);
    }
    else{
      return -1;
    }
  }

  /**
   * 批量删除组内通知
   *
   * @param noticeIds 需要删除的组内通知主键
   * @return 结果
   */
  @Override
  public int deleteNoticeByNoticeIds(Long[] noticeIds) {
    return noticeMapper.deleteNoticeByNoticeIds(noticeIds);
  }

  /**
   * 删除组内通知信息
   *
   * @param noticeId 组内通知主键
   * @return 结果
   */
  @Override
  public int deleteNoticeByNoticeId(Long noticeId) {
    return noticeMapper.deleteNoticeByNoticeId(noticeId);
  }
}
