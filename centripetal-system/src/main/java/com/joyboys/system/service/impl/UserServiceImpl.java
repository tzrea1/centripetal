package com.joyboys.system.service.impl;

import com.joyboys.common.constant.UserConstants;
import com.joyboys.common.core.domain.entity.User;
import com.joyboys.common.utils.StringUtils;
import com.joyboys.system.mapper.UserMapper;
import com.joyboys.system.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserMapper userMapper;

  /**
   * 查询用户
   *
   * @param userId 用户主键
   * @return 用户
   */
  @Override
  public User selectUserByUserId(Long userId) {
    return userMapper.selectUserByUserId(userId);
  }

  /**
   * 查询用户
   *
   * @param username 用户名
   * @return 用户
   */
  @Override
  public User selectUserByUserName(String username) {
    return userMapper.selectUserByUserName(username);
  }

  /**
   * 校验用户名称是否唯一
   *
   * @param user 用户信息
   * @return 结果
   */
  @Override
  public boolean checkUserNameUnique(User user) {
    Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
    User info = userMapper.checkUserNameUnique(user.getUsername());
    if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
      return UserConstants.NOT_UNIQUE;
    }
    return UserConstants.UNIQUE;
  }

  /**
   * 查询用户列表
   *
   * @param user 用户
   * @return 用户
   */
  @Override
  public List<User> selectUserList(User user) {
    return userMapper.selectUserList(user);
  }

  /**
   * 新增用户
   *
   * @param user 用户
   * @return 结果
   */
  @Override
  public int insertUser(User user) {
    return userMapper.insertUser(user);
  }

  /**
   * 注册用户信息
   *
   * @param user 用户信息
   * @return 结果
   */
  @Override
  public boolean registerUser(User user) {
    return userMapper.insertUser(user) > 0;
  }

  /**
   * 修改用户
   *
   * @param user 用户
   * @return 结果
   */
  @Override
  public int updateUser(User user) {
    return userMapper.updateUser(user);
  }

  /**
   * 批量删除用户
   *
   * @param userIds 需要删除的用户主键
   * @return 结果
   */
  @Override
  public int deleteUserByUserIds(Long[] userIds) {
    return userMapper.deleteUserByUserIds(userIds);
  }

  /**
   * 删除用户信息
   *
   * @param userId 用户主键
   * @return 结果
   */
  @Override
  public int deleteUserByUserId(Long userId) {
    return userMapper.deleteUserByUserId(userId);
  }
}
