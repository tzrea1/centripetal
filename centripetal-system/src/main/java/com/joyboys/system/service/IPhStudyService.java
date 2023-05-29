package com.joyboys.system.service;

import java.util.List;
import com.joyboys.system.domain.PhStudy;

/**
 * 党史内容学习活动Service接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface IPhStudyService 
{
    /**
     * 查询党史内容学习活动
     * 
     * @param phStudyId 党史内容学习活动主键
     * @return 党史内容学习活动
     */
    public PhStudy selectPhStudyByPhStudyId(Long phStudyId);

    /**
     * 查询党史内容学习活动列表
     * 
     * @param phStudy 党史内容学习活动
     * @return 党史内容学习活动集合
     */
    public List<PhStudy> selectPhStudyList(PhStudy phStudy);

    /**
     * 新增党史内容学习活动
     * 
     * @param phStudy 党史内容学习活动
     * @return 结果
     */
    public int insertPhStudy(PhStudy phStudy);

    /**
     * 修改党史内容学习活动
     * 
     * @param phStudy 党史内容学习活动
     * @return 结果
     */
    public int updatePhStudy(PhStudy phStudy);

    /**
     * 批量删除党史内容学习活动
     * 
     * @param phStudyIds 需要删除的党史内容学习活动主键集合
     * @return 结果
     */
    public int deletePhStudyByPhStudyIds(Long[] phStudyIds);

    /**
     * 删除党史内容学习活动信息
     * 
     * @param phStudyId 党史内容学习活动主键
     * @return 结果
     */
    public int deletePhStudyByPhStudyId(Long phStudyId);
}
