package com.joyboys.system.mapper;

import java.util.List;
import com.joyboys.system.domain.SceneUser;

/**
 * 用户虚拟场景间体验关系Mapper接口
 * 
 * @author joyboys
 * @date 2023-05-10
 */
public interface SceneUserMapper 
{
    /**
     * 查询用户虚拟场景间体验关系
     * 
     * @param userId 用户虚拟场景间体验关系主键
     * @return 用户虚拟场景间体验关系
     */
    public SceneUser selectSceneUserByUserId(Long userId);

    /**
     * 查询用户虚拟场景间体验关系列表
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 用户虚拟场景间体验关系集合
     */
    public List<SceneUser> selectSceneUserList(SceneUser sceneUser);

    /**
     * 新增用户虚拟场景间体验关系
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 结果
     */
    public int insertSceneUser(SceneUser sceneUser);

    /**
     * 修改用户虚拟场景间体验关系
     * 
     * @param sceneUser 用户虚拟场景间体验关系
     * @return 结果
     */
    public int updateSceneUser(SceneUser sceneUser);

    /**
     * 删除用户虚拟场景间体验关系
     * 
     * @param userId 用户虚拟场景间体验关系主键
     * @return 结果
     */
    public int deleteSceneUserByUserId(Long userId);

    /**
     * 批量删除用户虚拟场景间体验关系
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSceneUserByUserIds(Long[] userIds);
}
