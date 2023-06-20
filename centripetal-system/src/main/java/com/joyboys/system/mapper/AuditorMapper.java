package com.joyboys.system.mapper;

import com.joyboys.system.domain.Auditor;
import java.util.List;

/**
 * 审核员实体Mapper接口
 *
 * @author joyboys
 * @date 2023-05-10
 */
public interface AuditorMapper {

  /**
   * 查询审核员实体
   *
   * @param auditorId 审核员实体主键
   * @return 审核员实体
   */
  public Auditor selectAuditorByAuditorId(Long auditorId);

  /**
   * 查询审核员实体列表
   *
   * @param auditor 审核员实体
   * @return 审核员实体集合
   */
  public List<Auditor> selectAuditorList(Auditor auditor);

  /**
   * 新增审核员实体
   *
   * @param auditor 审核员实体
   * @return 结果
   */
  public int insertAuditor(Auditor auditor);

  /**
   * 修改审核员实体
   *
   * @param auditor 审核员实体
   * @return 结果
   */
  public int updateAuditor(Auditor auditor);

  /**
   * 删除审核员实体
   *
   * @param auditorId 审核员实体主键
   * @return 结果
   */
  public int deleteAuditorByAuditorId(Long auditorId);

  /**
   * 批量删除审核员实体
   *
   * @param auditorIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteAuditorByAuditorIds(Long[] auditorIds);
}
