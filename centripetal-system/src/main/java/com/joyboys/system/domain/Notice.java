package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 组内通知对象 notice
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class Notice extends BaseEntity {

  public Notice() {

  }

  public Notice(Long noticeId, Long userId, String content, String title, Date publishTime) {
    this.noticeId = noticeId;
    this.userId = userId;
    this.content = content;
    this.title = title;
    this.publishTime = publishTime;
  }

  private static final long serialVersionUID = 1L;

  /**
   * 小组通知id
   */
  private Long noticeId;

  /**
   * 组长id
   */
  @Excel(name = "组长id")
  private Long userId;

  /**
   * 通知内容
   */
  @Excel(name = "通知内容")
  private String content;

  /**
   * 通知标题
   */
  @Excel(name = "通知内容")
  private String title;

  /**
   * 发布时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date publishTime;

  public Long getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Long noticeId) {
    this.noticeId = noticeId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("noticeId", getNoticeId())
        .append("userId", getUserId())
        .append("content", getContent())
        .append("publishTime", getPublishTime())
        .append("title", getTitle())
        .toString();
  }
  public boolean isValid() {
    // Check if content is null or empty
    if (this.content == null || this.content.trim().isEmpty()) {
      return false;
    }

    // Check if title is null or empty
    if (this.title == null || this.title.trim().isEmpty()) {
      return false;
    }

    // Check if publishTime is null
    if (this.publishTime == null) {
      return false;
    }

    // If none of the checks failed, the object is valid
    return true;
  }

}
