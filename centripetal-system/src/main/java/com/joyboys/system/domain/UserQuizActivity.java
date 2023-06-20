package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * user用户参与答题活动的关系对象 user_quiz_activity
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class UserQuizActivity extends BaseEntity {

  public UserQuizActivity(){

  }

  public UserQuizActivity(Long userId, Long quizActivityId, Integer gotScores, Date startTime, Date endTime, String activityState,String isPassed){
    this.userId=userId;
    this.quizActivityId=quizActivityId;
    this.gotScores=gotScores;
    this.startTime=startTime;
    this.endTime=endTime;
    this.activityState=activityState;
    this.isPassed=isPassed;
  }

  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 答题活动id
   */
  private Long quizActivityId;

  /**
   * 得分
   */
  @Excel(name = "得分")
  private Integer gotScores;

  /**
   * 答题开始时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "答题开始时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date startTime;

  /**
   * 答题结束时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "答题结束时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date endTime;

  /**
   * 状态：是否结束了本次答题
   */
  @Excel(name = "状态：是否结束了本次答题")
  private String activityState;

  /**
   * 是否通过合格线
   */
  @Excel(name = "是否通过合格线")
  private String isPassed;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getQuizActivityId() {
    return quizActivityId;
  }

  public void setQuizActivityId(Long quizActivityId) {
    this.quizActivityId = quizActivityId;
  }

  public Integer getGotScores() {
    return gotScores;
  }

  public void setGotScores(Integer gotScores) {
    this.gotScores = gotScores;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getActivityState() {
    return activityState;
  }

  public void setActivityState(String activityState) {
    this.activityState = activityState;
  }

  public String getIsPassed() {
    return isPassed;
  }

  public void setIsPassed(String isPassed) {
    this.isPassed = isPassed;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("userId", getUserId())
        .append("quizActivityId", getQuizActivityId())
        .append("gotScores", getGotScores())
        .append("startTime", getStartTime())
        .append("endTime", getEndTime())
        .append("activityState", getActivityState())
        .append("isPassed", getIsPassed())
        .toString();
  }
  public boolean isValid() {
    if (gotScores == null || gotScores < 0) {
      System.out.println("Got scores is null or negative.");
      return false;
    }
    if (activityState == null || !(activityState.equals("审核") || activityState.equals("发布") || activityState.equals("已结束"))) {
      System.out.println("Activity state is not valid.");
      return false;
    }
    if (startTime == null || endTime == null || startTime.after(endTime) || startTime.equals(endTime)) {
      System.out.println("Start time or End time is null, or Start time is after End time.");
      return false;
    }
    if (isPassed == null || !(isPassed.equals("true") || isPassed.equals("false"))) {
      System.out.println("Is passed is not valid.");
      return false;
    }
    return true;
  }

}
