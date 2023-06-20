package com.joyboys.system.service;

import java.util.List;
import com.joyboys.common.core.domain.entity.User;

import java.util.Map;
import java.util.HashMap;

/**
 * 用户Service接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface IUserService 
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
     * @param user 用户信息
     * @return 结果
     */
    public boolean checkUserNameUnique(User user);

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
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public boolean registerUser(User user);

    /**
     * 修改用户
     * 
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteUserByUserIds(Long[] userIds);

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteUserByUserId(Long userId);

    public int updateUserGroupIds(Map<String, Object> params);
}
