package com.joyboys.system.domain;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 小组对象 group
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class Group extends BaseEntity {

  public Group() {

  }

  public Group(Long groupId, Long creatorId, String description, String groupname) {
    this.groupId=groupId;
    this.creatorId=creatorId;
    this.description=description;
    this.groupname=groupname;
  }

  private static final long serialVersionUID = 1L;

  /**
   * 组id，主键
   */
  private Long groupId;

  /**
   * 创建者负责人ID
   */
  @Excel(name = "创建者负责人ID")
  private Long creatorId;

  /**
   * 小组描述
   */
  @Excel(name = "小组描述")
  private String description;

  /**
   * 组名
   */
  @Excel(name = "组名")
  private String groupname;

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getGroupname() {
    return groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("groupId", getGroupId())
        .append("creatorId", getCreatorId())
        .append("description", getDescription())
        .append("groupname", getGroupname())
        .toString();
  }
  public boolean isValid() {
    if (this.description == null || this.description.trim().isEmpty()) {
      return false;
    }

    if (this.groupname == null || this.groupname.trim().isEmpty()) {
      return false;
    }

    return true;
  }
}
