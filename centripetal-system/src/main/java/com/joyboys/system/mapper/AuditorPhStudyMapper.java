package com.joyboys.system.mapper;

import com.joyboys.system.domain.AuditorPhStudy;
import java.util.List;

/**
 * 审核员审核党史内容学习的记录Mapper接口
 *
 * @author joyboys
 * @date 2023-05-08
 */
public interface AuditorPhStudyMapper {

  /**
   * 查询审核员审核党史内容学习的记录
   *
   * @param auditorId 审核员审核党史内容学习的记录主键
   * @return 审核员审核党史内容学习的记录
   */
  public AuditorPhStudy selectAuditorPhStudyByAuditorId(AuditorPhStudy auditorPhStudy);

  /**
   * 查询审核员审核党史内容学习的记录列表
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 审核员审核党史内容学习的记录集合
   */
  public List<AuditorPhStudy> selectAuditorPhStudyList(AuditorPhStudy auditorPhStudy);

  /**
   * 新增审核员审核党史内容学习的记录
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 结果
   */
  public int insertAuditorPhStudy(AuditorPhStudy auditorPhStudy);

  /**
   * 修改审核员审核党史内容学习的记录
   *
   * @param auditorPhStudy 审核员审核党史内容学习的记录
   * @return 结果
   */
  public int updateAuditorPhStudy(AuditorPhStudy auditorPhStudy);

  /**
   * 删除审核员审核党史内容学习的记录
   *
   * @param auditorId 审核员审核党史内容学习的记录主键
   * @return 结果
   */
  public int deleteAuditorPhStudyByAuditorId(Long auditorId);

  /**
   * 批量删除审核员审核党史内容学习的记录
   *
   * @param auditorIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteAuditorPhStudyByAuditorIds(List<AuditorPhStudy> auditorPhStudy);
}
