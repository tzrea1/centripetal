package com.joyboys.system.service.impl;

import com.joyboys.system.domain.AuditorPhStudy;
import com.joyboys.system.mapper.AuditorPhStudyMapper;
import com.joyboys.system.service.IAuditorPhStudyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 审核员审核党史内容学习的记录Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class AuditorPhStudyServiceImpl implements IAuditorPhStudyService {

  @Autowired
  private AuditorPhStudyMapper auditorPhStudyMapper;

  /**
   * 查询审核员审核党史内容学习的记录
   *
   * @param auditorId 审核员审核党史内容学习的记录主键
   * @return 审核员审核党史内容学习的记录
   */
  @Override
  public AuditorPhStudy selectAuditorPhStudyByAuditorId(AuditorPhStudy auditorPhStudy) {
    return auditorPhStudyMapper.selectAuditorPhStudyByAuditorId(auditorPhStudy);
  }

  /**
   * 查询审核员审核党史内容学习的记录列表
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 审核员审核党史内容学习的记录
   */
  @Override
  public List<AuditorPhStudy> selectAuditorPhStudyList(AuditorPhStudy auditorPhStudy) {
    return auditorPhStudyMapper.selectAuditorPhStudyList(auditorPhStudy);
  }

  /**
   * 新增审核员审核党史内容学习的记录
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 结果
   */
  @Override
  public int insertAuditorPhStudy(AuditorPhStudy auditorPhStudy) {
    return auditorPhStudyMapper.insertAuditorPhStudy(auditorPhStudy);
  }

  /**
   * 修改审核员审核党史内容学习的记录
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 结果
   */
  @Override
  public int updateAuditorPhStudy(AuditorPhStudy auditorPhStudy) {
    return auditorPhStudyMapper.updateAuditorPhStudy(auditorPhStudy);
  }

  /**
   * 批量删除审核员审核党史内容学习的记录
   *
   * @param auditorIds 需要删除的审核员审核党史内容学习的记录主键
   * @return 结果
   */
  @Override
  public int deleteAuditorPhStudyByAuditorIds(List<AuditorPhStudy> auditorPhStudy) {
    return auditorPhStudyMapper.deleteAuditorPhStudyByAuditorIds(auditorPhStudy);
  }

  /**
   * 删除审核员审核党史内容学习的记录信息
   *
   * @param auditorId 审核员审核党史内容学习的记录主键
   * @return 结果
   */
  @Override
  public int deleteAuditorPhStudyByAuditorId(Long auditorId) {
    return auditorPhStudyMapper.deleteAuditorPhStudyByAuditorId(auditorId);
  }
}
