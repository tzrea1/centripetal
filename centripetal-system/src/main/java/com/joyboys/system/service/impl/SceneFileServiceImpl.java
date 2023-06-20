package com.joyboys.system.service.impl;

import com.joyboys.system.domain.SceneFile;
import com.joyboys.system.mapper.SceneFileMapper;
import com.joyboys.system.service.ISceneFileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 虚拟场景相关文件Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-10
 */
@Service
public class SceneFileServiceImpl implements ISceneFileService {

  @Autowired
  private SceneFileMapper sceneFileMapper;

  /**
   * 查询虚拟场景相关文件
   *
   * @param scenefileId 虚拟场景相关文件主键
   * @return 虚拟场景相关文件
   */
  @Override
  public SceneFile selectSceneFileByScenefileId(Long scenefileId) {
    return sceneFileMapper.selectSceneFileByScenefileId(scenefileId);
  }

  /**
   * 查询虚拟场景相关文件列表
   *
   * @param sceneFile 虚拟场景相关文件
   * @return 虚拟场景相关文件
   */
  @Override
  public List<SceneFile> selectSceneFileList(SceneFile sceneFile) {
    return sceneFileMapper.selectSceneFileList(sceneFile);
  }

  /**
   * 新增虚拟场景相关文件
   *
   * @param sceneFile 虚拟场景相关文件
   * @return 结果
   */
  @Override
  public int insertSceneFile(SceneFile sceneFile) {
    return sceneFileMapper.insertSceneFile(sceneFile);
  }

  /**
   * 修改虚拟场景相关文件
   *
   * @param sceneFile 虚拟场景相关文件
   * @return 结果
   */
  @Override
  public int updateSceneFile(SceneFile sceneFile) {
    return sceneFileMapper.updateSceneFile(sceneFile);
  }

  /**
   * 批量删除虚拟场景相关文件
   *
   * @param scenefileIds 需要删除的虚拟场景相关文件主键
   * @return 结果
   */
  @Override
  public int deleteSceneFileByScenefileIds(Long[] scenefileIds) {
    return sceneFileMapper.deleteSceneFileByScenefileIds(scenefileIds);
  }

  /**
   * 删除虚拟场景相关文件信息
   *
   * @param scenefileId 虚拟场景相关文件主键
   * @return 结果
   */
  @Override
  public int deleteSceneFileByScenefileId(Long scenefileId) {
    return sceneFileMapper.deleteSceneFileByScenefileId(scenefileId);
  }
}
