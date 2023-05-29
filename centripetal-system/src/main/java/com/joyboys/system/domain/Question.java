package com.joyboys.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * 题目对象 question
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public class Question extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 题目id */
    private Long questionId;

    /** 题目内容 */
    @Excel(name = "题目内容")
    private String content;

    /** 本题分值 */
    @Excel(name = "本题分值")
    private Integer questionScore;

    /** 本题正确答案 */
    @Excel(name = "本题正确答案")
    private String correctAnswer;

    /** 本题选项 */
    @Excel(name = "本题选项")
    private String options;

    /** 答题活动id */
    @Excel(name = "答题活动id")
    private Long quizActivityId;

    /** 题目类型 */
    @Excel(name = "题目类型")
    private String questionType;

    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setQuestionScore(Integer questionScore) 
    {
        this.questionScore = questionScore;
    }

    public Integer getQuestionScore() 
    {
        return questionScore;
    }
    public void setCorrectAnswer(String correctAnswer) 
    {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }
    public void setOptions(String options) 
    {
        this.options = options;
    }

    public String getOptions() 
    {
        return options;
    }
    public void setQuizActivityId(Long quizActivityId) 
    {
        this.quizActivityId = quizActivityId;
    }

    public Long getQuizActivityId() 
    {
        return quizActivityId;
    }
    public void setQuestionType(String questionType) 
    {
        this.questionType = questionType;
    }

    public String getQuestionType() 
    {
        return questionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionId", getQuestionId())
            .append("content", getContent())
            .append("questionScore", getQuestionScore())
            .append("correctAnswer", getCorrectAnswer())
            .append("options", getOptions())
            .append("quizActivityId", getQuizActivityId())
            .append("questionType", getQuestionType())
            .toString();
    }
}
