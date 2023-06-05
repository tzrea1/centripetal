package com.joyboys.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joyboys.system.mapper.SceneUserMapper;
import com.joyboys.system.domain.SceneUser;
import com.joyboys.system.service.ISceneUserService;

/**
 * 用户虚拟场景间体验关系Service业务层处理
 * 
 * @author joyboys
 * @date 2023-05-10
 */
@Service
public class SceneUserServiceImpl implements ISceneUserService 
{
    @Autowired
    private SceneUserMapper sceneUserMapper;

    /**
     * 查询用户虚拟场景间体验关系
     * 
     * @param userId 用户虚拟场景间体验关系主键
     * @return 用户虚拟场景间体验关系
     */
    @Override
    public SceneUser selectSceneUserByUserId(Long userId)
    {
        return sceneUserMapper.selectSceneUserByUserId(userId);
    }

    /**
     * 查询用户虚拟场景间体验关系列表
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 用户虚拟场景间体验关系
     */
    @Override
    public List<SceneUser> selectSceneUserList(SceneUser sceneUser)
    {
        return sceneUserMapper.selectSceneUserList(sceneUser);
    }

    /**
     * 新增用户虚拟场景间体验关系
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 结果
     */
    @Override
    public int insertSceneUser(SceneUser sceneUser)
    {
        return sceneUserMapper.insertSceneUser(sceneUser);
    }

    /**
     * 修改用户虚拟场景间体验关系
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 结果
     */
    @Override
    public int updateSceneUser(SceneUser sceneUser)
    {
        return sceneUserMapper.updateSceneUser(sceneUser);
    }

    /**
     * 批量删除用户虚拟场景间体验关系
     * 
     * @param userIds 需要删除的用户虚拟场景间体验关系主键
     * @return 结果
     */
    @Override
    public int deleteSceneUserByUserIds(List<SceneUser> sceneUser)
    {
        return sceneUserMapper.deleteSceneUserByUserIds(sceneUser);
    }

    /**
     * 删除用户虚拟场景间体验关系信息
     * 
     * @param userId 用户虚拟场景间体验关系主键
     * @return 结果
     */
    @Override
    public int deleteSceneUserByUserId(Long userId)
    {
        return sceneUserMapper.deleteSceneUserByUserId(userId);
    }
}
