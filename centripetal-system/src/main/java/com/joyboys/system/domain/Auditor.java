package com.joyboys.system.domain;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审核员实体对象 auditor
 *
 * @author joyboys
 * @date 2023-05-10
 */
public class Auditor extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 审核员id
   */
  private Long auditorId;

  /**
   * 审核员姓名
   */
  @Excel(name = "审核员姓名")
  private String realname;

  /**
   * 审核员用户名
   */
  @Excel(name = "审核员用户名")
  private String nickname;

  /**
   * 审核员密码
   */
  @Excel(name = "审核员密码")
  private String password;

  /**
   * 审核员手机号
   */
  @Excel(name = "审核员手机号")
  private String phone;

  public Long getAuditorId() {
    return auditorId;
  }

  public void setAuditorId(Long auditorId) {
    this.auditorId = auditorId;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("auditorId", getAuditorId())
        .append("realname", getRealname())
        .append("nickname", getNickname())
        .append("password", getPassword())
        .append("phone", getPhone())
        .toString();
  }
}
