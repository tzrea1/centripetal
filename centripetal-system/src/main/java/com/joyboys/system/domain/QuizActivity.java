package com.joyboys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 答题活动对象 quiz_activity
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class QuizActivity extends BaseEntity {

  public QuizActivity(){

  }

  public QuizActivity(Long creatorId, String title, Long timeLimit, String description, Integer totalPoints, String state, Date startTime, Date endTime, Integer acceptanceLine, Integer quizNum){
    this.title=title;
    this.timeLimit=timeLimit;
    this.description=description;
    this.totalPoints=totalPoints;
    this.state=state;
    this.startTime=startTime;
    this.endTime=endTime;
    this.acceptanceLine=acceptanceLine;
    this.quizNum=quizNum;
  }

  private static final long serialVersionUID = 1L;

  /**
   * 答题活动id
   */
  private Long quizActivityId;

  /**
   * 创建此答题活动的负责人id
   */
  @Excel(name = "创建此答题活动的负责人id")
  private Long creatorId;

  /**
   * 答题活动名称
   */
  @Excel(name = "答题活动名称")
  private String title;

  /**
   * 答题时长
   */
  @Excel(name = "答题时长")
  private Long timeLimit;

  /**
   * 答题活动描述
   */
  @Excel(name = "答题活动描述")
  private String description;

  /**
   * 总分值
   */
  @Excel(name = "总分值")
  private Integer totalPoints;

  /**
   * 状态（审核或发布）
   */
  @Excel(name = "状态", readConverterExp = "审=核或发布")
  private String state;

  /**
   * 开始时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date startTime;

  /**
   * 结束时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date endTime;

  /**
   * 合格线
   */
  @Excel(name = "合格线")
  private Integer acceptanceLine;

  /**
   * 题目量
   */
  @Excel(name = "题目量")
  private Integer quizNum;

  /**
   * 题目信息
   */
  private List<Question> questionList;

  public Long getQuizActivityId() {
    return quizActivityId;
  }

  public void setQuizActivityId(Long quizActivityId) {
    this.quizActivityId = quizActivityId;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Long getTimeLimit() {
    return timeLimit;
  }

  public void setTimeLimit(Long timeLimit) {
    this.timeLimit = timeLimit;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getTotalPoints() {
    return totalPoints;
  }

  public void setTotalPoints(Integer totalPoints) {
    this.totalPoints = totalPoints;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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

  public Integer getAcceptanceLine() {
    return acceptanceLine;
  }

  public void setAcceptanceLine(Integer acceptanceLine) {
    this.acceptanceLine = acceptanceLine;
  }

  public Integer getQuizNum() {
    return quizNum;
  }

  public void setQuizNum(Integer quizNum) {
    this.quizNum = quizNum;
  }

  public List<Question> getQuestionList() {
    return questionList;
  }

  public void setQuestionList(List<Question> questionList) {
    this.questionList = questionList;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("quizActivityId", getQuizActivityId())
        .append("creatorId", getCreatorId())
        .append("title", getTitle())
        .append("timeLimit", getTimeLimit())
        .append("description", getDescription())
        .append("totalPoints", getTotalPoints())
        .append("state", getState())
        .append("startTime", getStartTime())
        .append("endTime", getEndTime())
        .append("acceptanceLine", getAcceptanceLine())
        .append("quizNum", getQuizNum())
        .append("questionList", getQuestionList())
        .toString();
  }
  public boolean isValid() {
    if (title == null || title.trim().isEmpty()) {
      System.out.println("Quiz Activity title is null or empty.");
      return false;
    }
    if (timeLimit == null || timeLimit <= 0 || timeLimit==Long.MAX_VALUE) {
      System.out.println("Quiz Activity timeLimit is null or non-positive value.");
      return false;
    }
    if (description == null) {
      System.out.println("Quiz Activity description is null.");
      return false;
    }
    if (totalPoints == null || totalPoints < 0 || totalPoints==Integer.MAX_VALUE) {
      System.out.println("Total points is null or negative.");
      return false;
    }
    if (state == null || !(state.equals("审核") || state.equals("发布") || state.equals("已结束"))) {
      System.out.println("State is not valid.");
      return false;
    }
    if (startTime == null || endTime == null || startTime.after(endTime) || startTime.equals(endTime)) {
      System.out.println("Start time or End time is null, or Start time is after End time.");
      return false;
    }
    if (acceptanceLine == null || acceptanceLine <= 0 || acceptanceLine > totalPoints) {
      System.out.println("Acceptance line is null, negative or greater than total points.");
      return false;
    }
    if (quizNum == null || quizNum <= 0||quizNum==Integer.MAX_VALUE) {
      System.out.println("Quiz Num is null or non-positive value.");
      return false;
    }
    if (questionList != null && !questionList.isEmpty()) {
      int totalQuestionScore = 0;
      for (Question question : questionList) {
        if (!question.isValid()) {
          System.out.println("One or more questions in the question list are not valid.");
          return false;
        }
        totalQuestionScore += question.getQuestionScore();
      }
      if (totalQuestionScore != totalPoints) {
        System.out.println("Sum of all question scores is not equal to the total points of the Quiz Activity.");
        return false;
      }
    }
    return true;
  }


}
