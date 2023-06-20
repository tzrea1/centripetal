package com.joyboys.system.mapper;

import com.joyboys.system.domain.Scene;
import java.util.List;

/**
 * 虚拟场景Mapper接口
 *
 * @author joyboys
 * @date 2023-05-10
 */
public interface SceneMapper {

  /**
   * 查询虚拟场景
   *
   * @param sceneId 虚拟场景主键
   * @return 虚拟场景
   */
  public Scene selectSceneBySceneId(Long sceneId);

  /**
   * 查询虚拟场景列表
   *
   * @param scene 虚拟场景
   * @return 虚拟场景集合
   */
  public List<Scene> selectSceneList(Scene scene);

  /**
   * 新增虚拟场景
   *
   * @param scene 虚拟场景
   * @return 结果
   */
  public int insertScene(Scene scene);

  /**
   * 修改虚拟场景
   *
   * @param scene 虚拟场景
   * @return 结果
   */
  public int updateScene(Scene scene);

  /**
   * 删除虚拟场景
   *
   * @param sceneId 虚拟场景主键
   * @return 结果
   */
  public int deleteSceneBySceneId(Long sceneId);

  /**
   * 批量删除虚拟场景
   *
   * @param sceneIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteSceneBySceneIds(Long[] sceneIds);
}
