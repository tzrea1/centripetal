package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审核员审核答题活动的记录对象 auditor_quiz_acitvity
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class AuditorQuizAcitvity extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 审核员id
   */
  private Long auditorId;

  /**
   * 答题活动id
   */
  private Long quizActivityId;

  /**
   * 审核时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date auditTime;

  public Long getAuditorId() {
    return auditorId;
  }

  public void setAuditorId(Long auditorId) {
    this.auditorId = auditorId;
  }

  public Long getQuizActivityId() {
    return quizActivityId;
  }

  public void setQuizActivityId(Long quizActivityId) {
    this.quizActivityId = quizActivityId;
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
        .append("quizActivityId", getQuizActivityId())
        .append("auditTime", getAuditTime())
        .toString();
  }
}
