package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户虚拟场景间体验关系对象 scene_user
 *
 * @author joyboys
 * @date 2023-05-10
 */
public class SceneUser extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 虚拟场景id
   */
  private Long sceneId;

  /**
   * 探索度
   */
  @Excel(name = "探索度")
  private BigDecimal explorationDegree;

  /**
   * 体验时长（单位：分钟）
   */
  @Excel(name = "体验时长", readConverterExp = "单=位：分钟")
  private Integer experienceDuration;

  /**
   * 体验开始时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "体验开始时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date startTime;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getSceneId() {
    return sceneId;
  }

  public void setSceneId(Long sceneId) {
    this.sceneId = sceneId;
  }

  public BigDecimal getExplorationDegree() {
    return explorationDegree;
  }

  public void setExplorationDegree(BigDecimal explorationDegree) {
    this.explorationDegree = explorationDegree;
  }

  public Integer getExperienceDuration() {
    return experienceDuration;
  }

  public void setExperienceDuration(Integer experienceDuration) {
    this.experienceDuration = experienceDuration;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("userId", getUserId())
        .append("sceneId", getSceneId())
        .append("explorationDegree", getExplorationDegree())
        .append("experienceDuration", getExperienceDuration())
        .append("startTime", getStartTime())
        .toString();
  }
}
