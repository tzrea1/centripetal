package com.joyboys.system.service;

import java.util.List;
import com.joyboys.system.domain.Auditor;

/**
 * 审核员实体Service接口
 * 
 * @author joyboys
 * @date 2023-05-10
 */
public interface IAuditorService 
{
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
     * 批量删除审核员实体
     * 
     * @param auditorIds 需要删除的审核员实体主键集合
     * @return 结果
     */
    public int deleteAuditorByAuditorIds(Long[] auditorIds);

    /**
     * 删除审核员实体信息
     * 
     * @param auditorId 审核员实体主键
     * @return 结果
     */
    public int deleteAuditorByAuditorId(Long auditorId);
}
