package com.joyboys.framework.web.service;

import com.joyboys.common.core.domain.entity.User;
import com.joyboys.system.service.IRoleService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户权限处理
 *
 * @author joyboys
 */
@Component
public class SysPermissionService {

  @Autowired
  private IRoleService roleService;

//    @Autowired
//    private ISysMenuService menuService;

  /**
   * 获取角色数据权限
   *
   * @param user 用户信息
   * @return 角色权限信息
   */
  public Set<String> getRolePermission(User user) {
    Set<String> roles = new HashSet<String>();
    // 管理员拥有所有权限
    if (user.isAdmin()) {
      roles.add("admin");
    } else {
      roles.addAll(roleService.selectRolePermissionByUserId(user.getUserId()));
    }
    return roles;
  }

  /**
   * 获取菜单数据权限
   *
   * @param user 用户信息
   * @return 菜单权限信息
   */
  public Set<String> getMenuPermission(User user) {
    Set<String> perms = new HashSet<String>();
    // 用户拥有所有权限
    perms.add("*:*:*");
//        // 管理员拥有所有权限
//        if (user.isAdmin())
//        {
//            perms.add("*:*:*");
//        }
//        else
//        {
//            List<Role> roles = user.getRoles();
//            if (!roles.isEmpty() && roles.size() > 1)
//            {
//                // 多角色设置permissions属性，以便数据权限匹配权限
//                for (Role role : roles)
//                {
//                    Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
//                    role.setPermissions(rolePerms);
//                    perms.addAll(rolePerms);
//                }
//            }
//            else
//            {
//                perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
//            }
//        }
    return perms;
  }
}
