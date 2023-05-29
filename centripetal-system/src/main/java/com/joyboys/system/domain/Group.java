package com.joyboys.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;

/**
 * 小组对象 group
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public class Group extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组id，主键 */
    private Long groupId;

    /** 创建者负责人ID */
    @Excel(name = "创建者负责人ID")
    private Long creatorId;

    /** 小组描述 */
    @Excel(name = "小组描述")
    private String description;

    /** 组名 */
    @Excel(name = "组名")
    private String groupname;

    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setGroupname(String groupname) 
    {
        this.groupname = groupname;
    }

    public String getGroupname() 
    {
        return groupname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupId", getGroupId())
            .append("creatorId", getCreatorId())
            .append("description", getDescription())
            .append("groupname", getGroupname())
            .toString();
    }
}
