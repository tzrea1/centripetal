package com.joyboys.system.mapper;

import com.joyboys.system.domain.AuditorQuizAcitvity;
import java.util.List;

/**
 * 审核员审核答题活动的记录Mapper接口
 *
 * @author joyboys
 * @date 2023-05-08
 */
public interface AuditorQuizAcitvityMapper {

  /**
   * 查询审核员审核答题活动的记录
   *
   * @param auditorId 审核员审核答题活动的记录主键
   * @return 审核员审核答题活动的记录
   */
  public AuditorQuizAcitvity selectAuditorQuizAcitvityByAuditorId(
      AuditorQuizAcitvity auditorQuizAcitvity);

  /**
   * 查询审核员审核答题活动的记录列表
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 审核员审核答题活动的记录集合
   */
  public List<AuditorQuizAcitvity> selectAuditorQuizAcitvityList(
      AuditorQuizAcitvity auditorQuizAcitvity);

  /**
   * 新增审核员审核答题活动的记录
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 结果
   */
  public int insertAuditorQuizAcitvity(AuditorQuizAcitvity auditorQuizAcitvity);

  /**
   * 修改审核员审核答题活动的记录
   *
   * @param auditorQuizAcitvity 审核员审核答题活动的记录
   * @return 结果
   */
  public int updateAuditorQuizAcitvity(AuditorQuizAcitvity auditorQuizAcitvity);

  /**
   * 删除审核员审核答题活动的记录
   *
   * @param auditorId 审核员审核答题活动的记录主键
   * @return 结果
   */
  public int deleteAuditorQuizAcitvityByAuditorId(Long auditorId);

  /**
   * 批量删除审核员审核答题活动的记录
   *
   * @param auditorIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteAuditorQuizAcitvityByAuditorIds(List<AuditorQuizAcitvity> auditorQuizAcitvities);
}
