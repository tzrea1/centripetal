package com.joyboys.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * user用户参与答题活动的关系对象 user_quiz_activity
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public class UserQuizActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 答题活动id */
    private Long quizActivityId;

    /** 得分 */
    @Excel(name = "得分")
    private Integer gotScores;

    /** 答题开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "答题开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 答题结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "答题结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态：是否结束了本次答题 */
    @Excel(name = "状态：是否结束了本次答题")
    private String activityState;

    /** 是否通过合格线 */
    @Excel(name = "是否通过合格线")
    private String isPassed;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setQuizActivityId(Long quizActivityId) 
    {
        this.quizActivityId = quizActivityId;
    }

    public Long getQuizActivityId() 
    {
        return quizActivityId;
    }
    public void setGotScores(Integer gotScores) 
    {
        this.gotScores = gotScores;
    }

    public Integer getGotScores() 
    {
        return gotScores;
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
    public void setActivityState(String activityState) 
    {
        this.activityState = activityState;
    }

    public String getActivityState() 
    {
        return activityState;
    }
    public void setIsPassed(String isPassed) 
    {
        this.isPassed = isPassed;
    }

    public String getIsPassed() 
    {
        return isPassed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("quizActivityId", getQuizActivityId())
            .append("gotScores", getGotScores())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("activityState", getActivityState())
            .append("isPassed", getIsPassed())
            .toString();
    }
}
