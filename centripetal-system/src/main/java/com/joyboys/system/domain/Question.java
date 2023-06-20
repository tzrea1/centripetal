package com.joyboys.system.domain;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.util.Arrays;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 题目对象 question
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class Question extends BaseEntity {

  public Question(){

  }
  public Question(Long quizActivityId, String content, Integer questionScore, String correctAnswer, String options, String questionType){
    this.content=content;
    this.quizActivityId=quizActivityId;
    this.questionScore=questionScore;
    this.correctAnswer=correctAnswer;
    this.options=options;
    this.questionType=questionType;
  }

  private static final long serialVersionUID = 1L;

  /**
   * 题目id
   */
  private Long questionId;

  /**
   * 题目内容
   */
  @Excel(name = "题目内容")
  private String content;

  /**
   * 本题分值
   */
  @Excel(name = "本题分值")
  private Integer questionScore;

  /**
   * 本题正确答案
   */
  @Excel(name = "本题正确答案")
  private String correctAnswer;

  /**
   * 本题选项
   */
  @Excel(name = "本题选项")
  private String options;

  /**
   * 答题活动id
   */
  @Excel(name = "答题活动id")
  private Long quizActivityId;

  /**
   * 题目类型
   */
  @Excel(name = "题目类型")
  private String questionType;

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getQuestionScore() {
    return questionScore;
  }

  public void setQuestionScore(Integer questionScore) {
    this.questionScore = questionScore;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }

  public Long getQuizActivityId() {
    return quizActivityId;
  }

  public void setQuizActivityId(Long quizActivityId) {
    this.quizActivityId = quizActivityId;
  }

  public String getQuestionType() {
    return questionType;
  }

  public void setQuestionType(String questionType) {
    this.questionType = questionType;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("questionId", getQuestionId())
        .append("content", getContent())
        .append("questionScore", getQuestionScore())
        .append("correctAnswer", getCorrectAnswer())
        .append("options", getOptions())
        .append("quizActivityId", getQuizActivityId())
        .append("questionType", getQuestionType())
        .toString();
  }

  public boolean isValid() {
    if (content == null || content.trim().isEmpty()) {
      System.out.println("Question content is null or empty.");
      return false;
    }
    if (questionScore == null || questionScore < 0) {
      System.out.println("Question score is null, negative or non-integer value.");
      return false;
    }
    if (correctAnswer == null || correctAnswer.trim().isEmpty()) {
      System.out.println("Correct answer is null or empty.");
      return false;
    }
    if (options == null || options.trim().isEmpty()) {
      System.out.println("Options are null or empty.");
      return false;
    }
    if (questionType == null || !(questionType.equals("1") || questionType.equals("2") || questionType.equals("3"))) {
      System.out.println("Question type is not 1, 2 or 3.");
      return false;
    }
    // Assuming options are separated by comma.
    if (!options.contains(correctAnswer)) {
      System.out.println("Correct answer is not included in options.");
      return false;
    }
    return true;
  }

}
