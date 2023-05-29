package com.joyboys.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * 党史内容学习活动对象 ph_study
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public class PhStudy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 党史内容学习活动ID */
    private Long phStudyId;

    /** 上传者ID */
    @Excel(name = "上传者ID")
    private Long creatorId;

    /** 党史内容学习活动标题 */
    @Excel(name = "党史内容学习活动标题")
    private String title;

    /** 党史内容学习活动简介 */
    @Excel(name = "党史内容学习活动简介")
    private String description;

    /** 党史内容学习活动状态 */
    @Excel(name = "党史内容学习活动状态")
    private String state;

    /** 党史内容学习活动预览图url */
    @Excel(name = "党史内容学习活动预览图url")
    private String prepicUrl;

    /** 党史内容学习内容主题 */
    @Excel(name = "党史内容学习内容主题")
    private String contentUrl;

    /** 党史内容学习文件信息 */
    private List<PhStudyFile> phStudyFileList;

    public void setPhStudyId(Long phStudyId) 
    {
        this.phStudyId = phStudyId;
    }

    public Long getPhStudyId() 
    {
        return phStudyId;
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
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setPrepicUrl(String prepicUrl) 
    {
        this.prepicUrl = prepicUrl;
    }

    public String getPrepicUrl() 
    {
        return prepicUrl;
    }
    public void setContentUrl(String contentUrl) 
    {
        this.contentUrl = contentUrl;
    }

    public String getContentUrl() 
    {
        return contentUrl;
    }

    public List<PhStudyFile> getPhStudyFileList()
    {
        return phStudyFileList;
    }

    public void setPhStudyFileList(List<PhStudyFile> phStudyFileList)
    {
        this.phStudyFileList = phStudyFileList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("phStudyId", getPhStudyId())
            .append("creatorId", getCreatorId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("state", getState())
            .append("prepicUrl", getPrepicUrl())
            .append("contentUrl", getContentUrl())
            .append("phStudyFileList", getPhStudyFileList())
            .toString();
    }
}
