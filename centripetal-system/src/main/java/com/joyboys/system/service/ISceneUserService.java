package com.joyboys.system.service;

import com.joyboys.system.domain.SceneUser;
import java.util.List;

/**
 * 用户虚拟场景间体验关系Service接口
 *
 * @author joyboys
 * @date 2023-05-10
 */
public interface ISceneUserService {

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
   * 批量删除用户虚拟场景间体验关系
   *
   * @param userIds 需要删除的用户虚拟场景间体验关系主键集合
   * @return 结果
   */
  public int deleteSceneUserByUserIds(List<SceneUser> sceneUser);

  /**
   * 删除用户虚拟场景间体验关系信息
   *
   * @param userId 用户虚拟场景间体验关系主键
   * @return 结果
   */
  public int deleteSceneUserByUserId(Long userId);
}
