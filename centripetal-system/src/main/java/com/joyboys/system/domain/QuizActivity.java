package com.joyboys.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * 答题活动对象 quiz_activity
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public class QuizActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 答题活动id */
    private Long quizActivityId;

    /** 创建此答题活动的负责人id */
    @Excel(name = "创建此答题活动的负责人id")
    private Long creatorId;

    /** 答题活动名称 */
    @Excel(name = "答题活动名称")
    private String title;

    /** 答题时长 */
    @Excel(name = "答题时长")
    private Long timeLimit;

    /** 答题活动描述 */
    @Excel(name = "答题活动描述")
    private String discription;

    /** 总分值 */
    @Excel(name = "总分值")
    private Integer totalPoints;

    /** 状态（审核或发布） */
    @Excel(name = "状态", readConverterExp = "审=核或发布")
    private String state;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 合格线 */
    @Excel(name = "合格线")
    private Integer acceptanceLine;

    /** 题目量 */
    @Excel(name = "题目量")
    private Integer quizNum;

    /** 题目信息 */
    private List<Question> questionList;

    public void setQuizActivityId(Long quizActivityId) 
    {
        this.quizActivityId = quizActivityId;
    }

    public Long getQuizActivityId() 
    {
        return quizActivityId;
    }
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTimeLimit(Long timeLimit) 
    {
        this.timeLimit = timeLimit;
    }

    public Long getTimeLimit() 
    {
        return timeLimit;
    }
    public void setDiscription(String discription) 
    {
        this.discription = discription;
    }

    public String getDiscription() 
    {
        return discription;
    }
    public void setTotalPoints(Integer totalPoints) 
    {
        this.totalPoints = totalPoints;
    }

    public Integer getTotalPoints() 
    {
        return totalPoints;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setAcceptanceLine(Integer acceptanceLine) 
    {
        this.acceptanceLine = acceptanceLine;
    }

    public Integer getAcceptanceLine() 
    {
        return acceptanceLine;
    }
    public void setQuizNum(Integer quizNum) 
    {
        this.quizNum = quizNum;
    }

    public Integer getQuizNum() 
    {
        return quizNum;
    }

    public List<Question> getQuestionList()
    {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList)
    {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quizActivityId", getQuizActivityId())
            .append("creatorId", getCreatorId())
            .append("title", getTitle())
            .append("timeLimit", getTimeLimit())
            .append("discription", getDiscription())
            .append("totalPoints", getTotalPoints())
            .append("state", getState())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("acceptanceLine", getAcceptanceLine())
            .append("quizNum", getQuizNum())
            .append("questionList", getQuestionList())
            .toString();
    }
}
