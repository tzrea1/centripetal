package com.joyboys.system.service.impl;

import com.joyboys.system.domain.Group;
import com.joyboys.system.mapper.GroupMapper;
import com.joyboys.system.service.IGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 小组Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class GroupServiceImpl implements IGroupService {

  @Autowired
  private GroupMapper groupMapper;

  /**
   * 查询小组
   *
   * @param groupId 小组主键
   * @return 小组
   */
  @Override
  public Group selectGroupByGroupId(Long groupId) {
    return groupMapper.selectGroupByGroupId(groupId);
  }

  /**
   * 查询小组列表
   *
   * @param group 小组
   * @return 小组
   */
  @Override
  public List<Group> selectGroupList(Group group) {
    return groupMapper.selectGroupList(group);
  }

  /**
   * 新增小组
   *
   * @param group 小组
   * @return 结果
   */
  @Override
  public int insertGroup(Group group) {
    if(group.isValid()){
      return groupMapper.insertGroup(group);
    }
    else{
      return -1;
    }
  }

  /**
   * 修改小组
   *
   * @param group 小组
   * @return 结果
   */
  @Override
  public int updateGroup(Group group) {
    if(group.isValid()){
      return groupMapper.updateGroup(group);
    }
    else{
      return -1;
    }
  }

  /**
   * 批量删除小组
   *
   * @param groupIds 需要删除的小组主键
   * @return 结果
   */
  @Override
  public int deleteGroupByGroupIds(Long[] groupIds) {
    return groupMapper.deleteGroupByGroupIds(groupIds);
  }

  /**
   * 删除小组信息
   *
   * @param groupId 小组主键
   * @return 结果
   */
  @Override
  public int deleteGroupByGroupId(Long groupId) {
    return groupMapper.deleteGroupByGroupId(groupId);
  }
}
