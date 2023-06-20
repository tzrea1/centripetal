package com.joyboys.system.domain;

import com.joyboys.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * user用户参与党史内容学习的关系对象 user_ph_study
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class UserPhStudy extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 党史内容学习活动ID
   */
  private Long phStudyId;

  /**
   * 用户ID
   */
  private Long userId;

  public Long getPhStudyId() {
    return phStudyId;
  }

  public void setPhStudyId(Long phStudyId) {
    this.phStudyId = phStudyId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("phStudyId", getPhStudyId())
        .append("userId", getUserId())
        .toString();
  }
}
