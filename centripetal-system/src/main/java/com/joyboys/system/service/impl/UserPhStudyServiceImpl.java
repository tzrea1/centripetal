package com.joyboys.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyboys.system.mapper.UserPhStudyMapper;
import com.joyboys.system.domain.UserPhStudy;
import com.joyboys.system.service.IUserPhStudyService;

/**
 * user用户参与党史内容学习的关系Service业务层处理
 * 
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class UserPhStudyServiceImpl implements IUserPhStudyService 
{
    @Autowired
    private UserPhStudyMapper userPhStudyMapper;

    /**
     * 查询user用户参与党史内容学习的关系
     * 
     * @param phStudyId user用户参与党史内容学习的关系主键
     * @return user用户参与党史内容学习的关系
     */
    @Override
    public UserPhStudy selectUserPhStudyByPhStudyId(Long phStudyId)
    {
        return userPhStudyMapper.selectUserPhStudyByPhStudyId(phStudyId);
    }

    /**
     * 查询user用户参与党史内容学习的关系列表
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return user用户参与党史内容学习的关系
     */
    @Override
    public List<UserPhStudy> selectUserPhStudyList(UserPhStudy userPhStudy)
    {
        return userPhStudyMapper.selectUserPhStudyList(userPhStudy);
    }

    /**
     * 新增user用户参与党史内容学习的关系
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return 结果
     */
    @Override
    public int insertUserPhStudy(UserPhStudy userPhStudy)
    {
        return userPhStudyMapper.insertUserPhStudy(userPhStudy);
    }

    /**
     * 修改user用户参与党史内容学习的关系
     * 
     * @param userPhStudy user用户参与党史内容学习的关系
     * @return 结果
     */
    @Override
    public int updateUserPhStudy(UserPhStudy userPhStudy)
    {
        return userPhStudyMapper.updateUserPhStudy(userPhStudy);
    }

    /**
     * 批量删除user用户参与党史内容学习的关系
     * 
     * @param phStudyIds 需要删除的user用户参与党史内容学习的关系主键
     * @return 结果
     */
    @Override
    public int deleteUserPhStudyByPhStudyIds(Long[] phStudyIds)
    {
        return userPhStudyMapper.deleteUserPhStudyByPhStudyIds(phStudyIds);
    }

    /**
     * 删除user用户参与党史内容学习的关系信息
     * 
     * @param phStudyId user用户参与党史内容学习的关系主键
     * @return 结果
     */
    @Override
    public int deleteUserPhStudyByPhStudyId(Long phStudyId)
    {
        return userPhStudyMapper.deleteUserPhStudyByPhStudyId(phStudyId);
    }
}
