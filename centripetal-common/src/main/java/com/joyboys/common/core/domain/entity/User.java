package com.joyboys.common.core.domain.entity;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.annotation.Excel.ColumnType;
import com.joyboys.common.annotation.Excel.Type;
import com.joyboys.common.annotation.Excels;
import com.joyboys.common.core.domain.BaseEntity;
import com.joyboys.common.xss.Xss;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 用户对象 user
 *
 * @author joyboys
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /** 部门ID */
    @Excel(name = "小组编号", type = Type.IMPORT)
    private Long groupId;

    /** 用户账号 */
    @Excel(name = "登录名称")
    private String username;

    /** 用户昵称 */
    @Excel(name = "用户名称")
    private String nickname;

    /** 用户昵称 */
    @Excel(name = "用户真实姓名")
    private String realname;


    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;


    /** 密码 */
    private String password;

    /** 角色对象 */
    private List<Role> roles;

    /** 角色组 */
    private Long[] roleIds;


    /** 角色ID */
    private Long roleId;

    public User()
    {

    }

    public User(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getGroupId()
    {
        return groupId;
    }

    public void setDeptId(Long groupId)
    {
        this.groupId = groupId;
    }

    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickName)
    {
        this.nickname = nickName;
    }


    @Xss(message = "用户姓名不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户姓名长度不能超过30个字符")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String userName)
    {
        this.username = userName;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phonenumber)
    {
        this.phone = phonenumber;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("groupId", getGroupId())
            .append("userName", getUsername())
            .append("nickName", getNickname())
            .append("realname", getRealname())
            .append("phone", getPhone())
            .append("password", getPassword())
            .toString();
    }
}
