package com.joyboys.system.service.impl;

import com.joyboys.system.domain.AuditorQuizAcitvity;
import com.joyboys.system.mapper.AuditorQuizAcitvityMapper;
import com.joyboys.system.service.IAuditorQuizAcitvityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 审核员审核答题活动的记录Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class AuditorQuizAcitvityServiceImpl implements IAuditorQuizAcitvityService {

  @Autowired
  private AuditorQuizAcitvityMapper auditorQuizAcitvityMapper;

  /**
   * 查询审核员审核答题活动的记录
   *
   * @param auditorId 审核员审核答题活动的记录主键
   * @return 审核员审核答题活动的记录
   */
  @Override
  public AuditorQuizAcitvity selectAuditorQuizAcitvityByAuditorId(
      AuditorQuizAcitvity auditorQuizAcitvity) {
    return auditorQuizAcitvityMapper.selectAuditorQuizAcitvityByAuditorId(auditorQuizAcitvity);
  }

  /**
   * 查询审核员审核答题活动的记录列表
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 审核员审核答题活动的记录
   */
  @Override
  public List<AuditorQuizAcitvity> selectAuditorQuizAcitvityList(
      AuditorQuizAcitvity auditorQuizAcitvity) {
    return auditorQuizAcitvityMapper.selectAuditorQuizAcitvityList(auditorQuizAcitvity);
  }

  /**
   * 新增审核员审核答题活动的记录
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 结果
   */
  @Override
  public int insertAuditorQuizAcitvity(AuditorQuizAcitvity auditorQuizAcitvity) {
    return auditorQuizAcitvityMapper.insertAuditorQuizAcitvity(auditorQuizAcitvity);
  }

  /**
   * 修改审核员审核答题活动的记录
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 结果
   */
  @Override
  public int updateAuditorQuizAcitvity(AuditorQuizAcitvity auditorQuizAcitvity) {
    return auditorQuizAcitvityMapper.updateAuditorQuizAcitvity(auditorQuizAcitvity);
  }

  /**
   * 批量删除审核员审核答题活动的记录
   *
   * @param auditorIds 需要删除的审核员审核答题活动的记录主键
   * @return 结果
   */
  @Override
  public int deleteAuditorQuizAcitvityByAuditorIds(
      List<AuditorQuizAcitvity> auditorQuizAcitvities) {
    return auditorQuizAcitvityMapper.deleteAuditorQuizAcitvityByAuditorIds(auditorQuizAcitvities);
  }

  /**
   * 删除审核员审核答题活动的记录信息
   *
   * @param auditorId 审核员审核答题活动的记录主键
   * @return 结果
   */
  @Override
  public int deleteAuditorQuizAcitvityByAuditorId(Long auditorId) {
    return auditorQuizAcitvityMapper.deleteAuditorQuizAcitvityByAuditorId(auditorId);
  }
}
