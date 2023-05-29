package com.joyboys.system.mapper;

import java.util.List;
import com.joyboys.system.domain.UserQuizActivity;

/**
 * user用户参与答题活动的关系Mapper接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface UserQuizActivityMapper 
{
    /**
     * 查询user用户参与答题活动的关系
     * 
     * @param userId user用户参与答题活动的关系主键
     * @return user用户参与答题活动的关系
     */
    public UserQuizActivity selectUserQuizActivityByUserId(Long userId);

    /**
     * 查询user用户参与答题活动的关系列表
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return user用户参与答题活动的关系集合
     */
    public List<UserQuizActivity> selectUserQuizActivityList(UserQuizActivity userQuizActivity);

    /**
     * 新增user用户参与答题活动的关系
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return 结果
     */
    public int insertUserQuizActivity(UserQuizActivity userQuizActivity);

    /**
     * 修改user用户参与答题活动的关系
     * 
     * @param userQuizActivity user用户参与答题活动的关系
     * @return 结果
     */
    public int updateUserQuizActivity(UserQuizActivity userQuizActivity);

    /**
     * 删除user用户参与答题活动的关系
     * 
     * @param userId user用户参与答题活动的关系主键
     * @return 结果
     */
    public int deleteUserQuizActivityByUserId(Long userId);

    /**
     * 批量删除user用户参与答题活动的关系
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserQuizActivityByUserIds(Long[] userIds);
}
