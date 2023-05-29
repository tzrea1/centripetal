package com.joyboys.system.mapper;

import java.util.List;
import com.joyboys.system.domain.Group;

/**
 * 小组Mapper接口
 * 
 * @author joyboys
 * @date 2023-05-08
 */
public interface GroupMapper 
{
    /**
     * 查询小组
     * 
     * @param groupId 小组主键
     * @return 小组
     */
    public Group selectGroupByGroupId(Long groupId);

    /**
     * 查询小组列表
     * 
     * @param group 小组
     * @return 小组集合
     */
    public List<Group> selectGroupList(Group group);

    /**
     * 新增小组
     * 
     * @param group 小组
     * @return 结果
     */
    public int insertGroup(Group group);

    /**
     * 修改小组
     * 
     * @param group 小组
     * @return 结果
     */
    public int updateGroup(Group group);

    /**
     * 删除小组
     * 
     * @param groupId 小组主键
     * @return 结果
     */
    public int deleteGroupByGroupId(Long groupId);

    /**
     * 批量删除小组
     * 
     * @param groupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGroupByGroupIds(Long[] groupIds);
}
