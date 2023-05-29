package com.joyboys.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * 虚拟场景对象 scene
 * 
 * @author joyboys
 * @date 2023-05-10
 */
public class Scene extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 虚拟场景体验id */
    private Long sceneId;

    /** 虚拟场景体验名称 */
    @Excel(name = "虚拟场景体验名称")
    private String scenename;

    /** 简要描述 */
    @Excel(name = "简要描述")
    private String discription;

    /** 主题 */
    @Excel(name = "主题")
    private String theme;

    /** 预览图url */
    @Excel(name = "预览图url")
    private String prepicUrl;

    public void setSceneId(Long sceneId) 
    {
        this.sceneId = sceneId;
    }

    public Long getSceneId() 
    {
        return sceneId;
    }
    public void setScenename(String scenename) 
    {
        this.scenename = scenename;
    }

    public String getScenename() 
    {
        return scenename;
    }
    public void setDiscription(String discription) 
    {
        this.discription = discription;
    }

    public String getDiscription() 
    {
        return discription;
    }
    public void setTheme(String theme) 
    {
        this.theme = theme;
    }

    public String getTheme() 
    {
        return theme;
    }
    public void setPrepicUrl(String prepicUrl) 
    {
        this.prepicUrl = prepicUrl;
    }

    public String getPrepicUrl() 
    {
        return prepicUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sceneId", getSceneId())
            .append("scenename", getScenename())
            .append("discription", getDiscription())
            .append("theme", getTheme())
            .append("prepicUrl", getPrepicUrl())
            .toString();
    }
}
