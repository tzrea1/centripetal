package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审核员审核党史内容学习的记录对象 auditor_ph_study
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class AuditorPhStudy extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 审核员ID
   */
  private Long auditorId;

  /**
   * 党史学习活动ID
   */
  private Long phStudyId;

  /**
   * 审核操作时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "审核操作时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date auditTime;

  public Long getAuditorId() {
    return auditorId;
  }

  public void setAuditorId(Long auditorId) {
    this.auditorId = auditorId;
  }

  public Long getPhStudyId() {
    return phStudyId;
  }

  public void setPhStudyId(Long phStudyId) {
    this.phStudyId = phStudyId;
  }

  public Date getAuditTime() {
    return auditTime;
  }

  public void setAuditTime(Date auditTime) {
    this.auditTime = auditTime;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("auditorId", getAuditorId())
        .append("phStudyId", getPhStudyId())
        .append("auditTime", getAuditTime())
        .toString();
  }
}
