package com.joyboys.system.mapper;

import com.joyboys.system.domain.PhStudy;
import com.joyboys.system.domain.PhStudyFile;
import java.util.List;

/**
 * 党史内容学习活动Mapper接口
 *
 * @author joyboys
 * @date 2023-05-08
 */
public interface PhStudyMapper {

  /**
   * 查询党史内容学习活动
   *
   * @param phStudyId 党史内容学习活动主键
   * @return 党史内容学习活动
   */
  public PhStudy selectPhStudyByPhStudyId(Long phStudyId);

  /**
   * 查询党史内容学习活动列表
   *
   * @param phStudy 党史内容学习活动
   * @return 党史内容学习活动集合
   */
  public List<PhStudy> selectPhStudyList(PhStudy phStudy);

  /**
   * 新增党史内容学习活动
   *
   * @param phStudy 党史内容学习活动
   * @return 结果
   */
  public int insertPhStudy(PhStudy phStudy);

  /**
   * 修改党史内容学习活动
   *
   * @param phStudy 党史内容学习活动
   * @return 结果
   */
  public int updatePhStudy(PhStudy phStudy);

  /**
   * 删除党史内容学习活动
   *
   * @param phStudyId 党史内容学习活动主键
   * @return 结果
   */
  public int deletePhStudyByPhStudyId(Long phStudyId);

  /**
   * 批量删除党史内容学习活动
   *
   * @param phStudyIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deletePhStudyByPhStudyIds(Long[] phStudyIds);

  /**
   * 批量删除党史内容学习文件
   *
   * @param phStudyIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deletePhStudyFileByPhStudyIds(Long[] phStudyIds);

  /**
   * 批量新增党史内容学习文件
   *
   * @param phStudyFileList 党史内容学习文件列表
   * @return 结果
   */
  public int batchPhStudyFile(List<PhStudyFile> phStudyFileList);


  /**
   * 通过党史内容学习活动主键删除党史内容学习文件信息
   *
   * @param phStudyId 党史内容学习活动ID
   * @return 结果
   */
  public int deletePhStudyFileByPhStudyId(Long phStudyId);
}
