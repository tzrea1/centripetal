package com.joyboys.system.service;

import java.util.List;
import com.joyboys.system.domain.SceneFile;

/**
 * 虚拟场景相关文件Service接口
 * 
 * @author joyboys
 * @date 2023-05-10
 */
public interface ISceneFileService 
{
    /**
     * 查询虚拟场景相关文件
     * 
     * @param scenefileId 虚拟场景相关文件主键
     * @return 虚拟场景相关文件
     */
    public SceneFile selectSceneFileByScenefileId(Long scenefileId);

    /**
     * 查询虚拟场景相关文件列表
     * 
     * @param sceneFile 虚拟场景相关文件
     * @return 虚拟场景相关文件集合
     */
    public List<SceneFile> selectSceneFileList(SceneFile sceneFile);

    /**
     * 新增虚拟场景相关文件
     * 
     * @param sceneFile 虚拟场景相关文件
     * @return 结果
     */
    public int insertSceneFile(SceneFile sceneFile);

    /**
     * 修改虚拟场景相关文件
     * 
     * @param sceneFile 虚拟场景相关文件
     * @return 结果
     */
    public int updateSceneFile(SceneFile sceneFile);

    /**
     * 批量删除虚拟场景相关文件
     * 
     * @param scenefileIds 需要删除的虚拟场景相关文件主键集合
     * @return 结果
     */
    public int deleteSceneFileByScenefileIds(Long[] scenefileIds);

    /**
     * 删除虚拟场景相关文件信息
     * 
     * @param scenefileId 虚拟场景相关文件主键
     * @return 结果
     */
    public int deleteSceneFileByScenefileId(Long scenefileId);
}
