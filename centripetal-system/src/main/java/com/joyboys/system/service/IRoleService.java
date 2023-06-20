package com.joyboys.system.service;

import com.joyboys.common.core.domain.entity.Role;
import com.joyboys.system.domain.UserRole;
import java.util.List;
import java.util.Set;

/**
 * 角色业务层
 *
 * @author ruoyi
 */
public interface IRoleService {

  /**
   * 根据条件分页查询角色数据
   *
   * @param role 角色信息
   * @return 角色数据集合信息
   */
  public List<Role> selectRoleList(Role role);

  /**
   * 根据用户ID查询角色列表
   *
   * @param userId 用户ID
   * @return 角色列表
   */
  public List<Role> selectRolesByUserId(Long userId);

  /**
   * 根据用户ID查询角色权限
   *
   * @param userId 用户ID
   * @return 权限列表
   */
  public Set<String> selectRolePermissionByUserId(Long userId);

  /**
   * 查询所有角色
   *
   * @return 角色列表
   */
  public List<Role> selectRoleAll();

  /**
   * 根据用户ID获取角色选择框列表
   *
   * @param userId 用户ID
   * @return 选中角色ID列表
   */
  public List<Long> selectRoleListByUserId(Long userId);

  /**
   * 通过角色ID查询角色
   *
   * @param roleId 角色ID
   * @return 角色对象信息
   */
  public Role selectRoleById(Long roleId);

  /**
   * 校验角色名称是否唯一
   *
   * @param role 角色信息
   * @return 结果
   */
  public boolean checkRoleNameUnique(Role role);

  /**
   * 校验角色权限是否唯一
   *
   * @param role 角色信息
   * @return 结果
   */
  public boolean checkRoleKeyUnique(Role role);

  /**
   * 校验角色是否允许操作
   *
   * @param role 角色信息
   */
  public void checkRoleAllowed(Role role);

  /**
   * 通过角色ID查询角色使用数量
   *
   * @param roleId 角色ID
   * @return 结果
   */
  public int countUserRoleByRoleId(Long roleId);

  /**
   * 新增保存角色信息
   *
   * @param role 角色信息
   * @return 结果
   */
  public int insertRole(Role role);

  /**
   * 修改保存角色信息
   *
   * @param role 角色信息
   * @return 结果
   */
  public int updateRole(Role role);

  /**
   * 修改角色状态
   *
   * @param role 角色信息
   * @return 结果
   */
  public int updateRoleStatus(Role role);

  /**
   * 通过角色ID删除角色
   *
   * @param roleId 角色ID
   * @return 结果
   */
  public int deleteRoleById(Long roleId);

  /**
   * 批量删除角色信息
   *
   * @param roleIds 需要删除的角色ID
   * @return 结果
   */
  public int deleteRoleByIds(Long[] roleIds);

  /**
   * 取消授权用户角色
   *
   * @param userRole 用户和角色关联信息
   * @return 结果
   */
  public int deleteAuthUser(UserRole userRole);

  /**
   * 批量取消授权用户角色
   *
   * @param roleId  角色ID
   * @param userIds 需要取消授权的用户数据ID
   * @return 结果
   */
  public int deleteAuthUsers(Long roleId, Long[] userIds);

  /**
   * 批量选择授权用户角色
   *
   * @param roleId  角色ID
   * @param userIds 需要删除的用户数据ID
   * @return 结果
   */
  public int insertAuthUsers(Long roleId, Long[] userIds);
}
