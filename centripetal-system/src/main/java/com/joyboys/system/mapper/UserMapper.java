package com.joyboys.system.mapper;

import java.util.List;
import com.joyboys.common.core.domain.entity.User;

import java.util.Map;
import java.util.HashMap;

/**
 * 用户Mapper接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface UserMapper 
{

    /**
     * 查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    public User selectUserByUserName(String username);

    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    public User selectUserByUserId(Long userId);


    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public User checkUserNameUnique(String userName);

    /**
     * 查询用户列表
     * 
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户
     * 
     * @param user 用户
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户
     * 
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteUserByUserId(Long userId);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUserIds(Long[] userIds);


    /**
     * 批量更新用户的groupId
     *
     * @param userIds 用户主键列表
     * @param groupId 组主键
     * @return 结果
     */
    public int updateUserGroupIds(Map<String, Object> params);

}
