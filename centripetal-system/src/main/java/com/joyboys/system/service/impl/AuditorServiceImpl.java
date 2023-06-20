package com.joyboys.system.service.impl;

import com.joyboys.system.domain.Auditor;
import com.joyboys.system.mapper.AuditorMapper;
import com.joyboys.system.service.IAuditorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 审核员实体Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-10
 */
@Service
public class AuditorServiceImpl implements IAuditorService {

  @Autowired
  private AuditorMapper auditorMapper;

  /**
   * 查询审核员实体
   *
   * @param auditorId 审核员实体主键
   * @return 审核员实体
   */
  @Override
  public Auditor selectAuditorByAuditorId(Long auditorId) {
    return auditorMapper.selectAuditorByAuditorId(auditorId);
  }

  /**
   * 查询审核员实体列表
   *
   * @param auditor 审核员实体
   * @return 审核员实体
   */
  @Override
  public List<Auditor> selectAuditorList(Auditor auditor) {
    return auditorMapper.selectAuditorList(auditor);
  }

  /**
   * 新增审核员实体
   *
   * @param auditor 审核员实体
   * @return 结果
   */
  @Override
  public int insertAuditor(Auditor auditor) {
    return auditorMapper.insertAuditor(auditor);
  }

  /**
   * 修改审核员实体
   *
   * @param auditor 审核员实体
   * @return 结果
   */
  @Override
  public int updateAuditor(Auditor auditor) {
    return auditorMapper.updateAuditor(auditor);
  }

  /**
   * 批量删除审核员实体
   *
   * @param auditorIds 需要删除的审核员实体主键
   * @return 结果
   */
  @Override
  public int deleteAuditorByAuditorIds(Long[] auditorIds) {
    return auditorMapper.deleteAuditorByAuditorIds(auditorIds);
  }

  /**
   * 删除审核员实体信息
   *
   * @param auditorId 审核员实体主键
   * @return 结果
   */
  @Override
  public int deleteAuditorByAuditorId(Long auditorId) {
    return auditorMapper.deleteAuditorByAuditorId(auditorId);
  }
}
