package com.joyboys.system.mapper;

import java.util.List;
import com.joyboys.system.domain.UserPhStudy;

/**
 * user用户参与党史内容学习的关系Mapper接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface UserPhStudyMapper 
{
    /**
     * 查询user用户参与党史内容学习的关系
     * 
     * @param phStudyId user用户参与党史内容学习的关系主键
     * @return user用户参与党史内容学习的关系
     */
    public UserPhStudy selectUserPhStudyByPhStudyId(Long phStudyId);

    /**
     * 查询user用户参与党史内容学习的关系列表
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return user用户参与党史内容学习的关系集合
     */
    public List<UserPhStudy> selectUserPhStudyList(UserPhStudy userPhStudy);

    /**
     * 新增user用户参与党史内容学习的关系
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return 结果
     */
    public int insertUserPhStudy(UserPhStudy userPhStudy);

    /**
     * 修改user用户参与党史内容学习的关系
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return 结果
     */
    public int updateUserPhStudy(UserPhStudy userPhStudy);

    /**
     * 删除user用户参与党史内容学习的关系
     * 
     * @param phStudyId user用户参与党史内容学习的关系主键
     * @return 结果
     */
    public int deleteUserPhStudyByPhStudyId(Long phStudyId);

    /**
     * 批量删除user用户参与党史内容学习的关系
     * 
     * @param phStudyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserPhStudyByPhStudyIds(Long[] phStudyIds);
}
