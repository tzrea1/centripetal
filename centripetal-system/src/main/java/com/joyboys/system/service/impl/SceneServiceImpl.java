package com.joyboys.system.service.impl;

import com.joyboys.system.domain.Scene;
import com.joyboys.system.mapper.SceneMapper;
import com.joyboys.system.service.ISceneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 虚拟场景Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-10
 */
@Service
public class SceneServiceImpl implements ISceneService {

  @Autowired
  private SceneMapper sceneMapper;

  /**
   * 查询虚拟场景
   *
   * @param sceneId 虚拟场景主键
   * @return 虚拟场景
   */
  @Override
  public Scene selectSceneBySceneId(Long sceneId) {
    return sceneMapper.selectSceneBySceneId(sceneId);
  }

  /**
   * 查询虚拟场景列表
   *
   * @param scene 虚拟场景
   * @return 虚拟场景
   */
  @Override
  public List<Scene> selectSceneList(Scene scene) {
    return sceneMapper.selectSceneList(scene);
  }

  /**
   * 新增虚拟场景
   *
   * @param scene 虚拟场景
   * @return 结果
   */
  @Override
  public int insertScene(Scene scene) {
    return sceneMapper.insertScene(scene);
  }

  /**
   * 修改虚拟场景
   *
   * @param scene 虚拟场景
   * @return 结果
   */
  @Override
  public int updateScene(Scene scene) {
    return sceneMapper.updateScene(scene);
  }

  /**
   * 批量删除虚拟场景
   *
   * @param sceneIds 需要删除的虚拟场景主键
   * @return 结果
   */
  @Override
  public int deleteSceneBySceneIds(Long[] sceneIds) {
    return sceneMapper.deleteSceneBySceneIds(sceneIds);
  }

  /**
   * 删除虚拟场景信息
   *
   * @param sceneId 虚拟场景主键
   * @return 结果
   */
  @Override
  public int deleteSceneBySceneId(Long sceneId) {
    return sceneMapper.deleteSceneBySceneId(sceneId);
  }
}
