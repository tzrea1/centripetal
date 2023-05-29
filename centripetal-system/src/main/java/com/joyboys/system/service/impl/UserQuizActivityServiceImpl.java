package com.joyboys.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyboys.system.mapper.UserQuizActivityMapper;
import com.joyboys.system.domain.UserQuizActivity;
import com.joyboys.system.service.IUserQuizActivityService;

/**
 * user用户参与答题活动的关系Service业务层处理
 * 
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class UserQuizActivityServiceImpl implements IUserQuizActivityService 
{
    @Autowired
    private UserQuizActivityMapper userQuizActivityMapper;

    /**
     * 查询user用户参与答题活动的关系
     * 
     * @param userId user用户参与答题活动的关系主键
     * @return user用户参与答题活动的关系
     */
    @Override
    public UserQuizActivity selectUserQuizActivityByUserId(Long userId)
    {
        return userQuizActivityMapper.selectUserQuizActivityByUserId(userId);
    }

    /**
     * 查询user用户参与答题活动的关系列表
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return user用户参与答题活动的关系
     */
    @Override
    public List<UserQuizActivity> selectUserQuizActivityList(UserQuizActivity userQuizActivity)
    {
        return userQuizActivityMapper.selectUserQuizActivityList(userQuizActivity);
    }

    /**
     * 新增user用户参与答题活动的关系
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return 结果
     */
    @Override
    public int insertUserQuizActivity(UserQuizActivity userQuizActivity)
    {
        return userQuizActivityMapper.insertUserQuizActivity(userQuizActivity);
    }

    /**
     * 修改user用户参与答题活动的关系
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return 结果
     */
    @Override
    public int updateUserQuizActivity(UserQuizActivity userQuizActivity)
    {
        return userQuizActivityMapper.updateUserQuizActivity(userQuizActivity);
    }

    /**
     * 批量删除user用户参与答题活动的关系
     * 
     * @param userIds 需要删除的user用户参与答题活动的关系主键
     * @return 结果
     */
    @Override
    public int deleteUserQuizActivityByUserIds(Long[] userIds)
    {
        return userQuizActivityMapper.deleteUserQuizActivityByUserIds(userIds);
    }

    /**
     * 删除user用户参与答题活动的关系信息
     * 
     * @param userId user用户参与答题活动的关系主键
     * @return 结果
     */
    @Override
    public int deleteUserQuizActivityByUserId(Long userId)
    {
        return userQuizActivityMapper.deleteUserQuizActivityByUserId(userId);
    }
}
