package com.joyboys.system.service.impl;

import com.joyboys.common.utils.StringUtils;
import com.joyboys.system.domain.PhStudy;
import com.joyboys.system.domain.PhStudyFile;
import com.joyboys.system.mapper.PhStudyMapper;
import com.joyboys.system.service.IPhStudyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 党史内容学习活动Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class PhStudyServiceImpl implements IPhStudyService {

  @Autowired
  private PhStudyMapper phStudyMapper;

  /**
   * 查询党史内容学习活动
   *
   * @param phStudyId 党史内容学习活动主键
   * @return 党史内容学习活动
   */
  @Override
  public PhStudy selectPhStudyByPhStudyId(Long phStudyId) {
    return phStudyMapper.selectPhStudyByPhStudyId(phStudyId);
  }

  /**
   * 查询党史内容学习活动列表
   *
   * @param phStudy 党史内容学习活动
   * @return 党史内容学习活动
   */
  @Override
  public List<PhStudy> selectPhStudyList(PhStudy phStudy) {
    return phStudyMapper.selectPhStudyList(phStudy);
  }

  /**
   * 新增党史内容学习活动
   *
   * @param phStudy 党史内容学习活动
   * @return 结果
   */
  @Transactional
  @Override
  public int insertPhStudy(PhStudy phStudy) {
    int rows = phStudyMapper.insertPhStudy(phStudy);
    insertPhStudyFile(phStudy);
    return rows;
  }

  /**
   * 修改党史内容学习活动
   *
   * @param phStudy 党史内容学习活动
   * @return 结果
   */
  @Transactional
  @Override
  public int updatePhStudy(PhStudy phStudy) {
    phStudyMapper.deletePhStudyFileByPhStudyId(phStudy.getPhStudyId());
    insertPhStudyFile(phStudy);
    return phStudyMapper.updatePhStudy(phStudy);
  }

  /**
   * 批量删除党史内容学习活动
   *
   * @param phStudyIds 需要删除的党史内容学习活动主键
   * @return 结果
   */
  @Transactional
  @Override
  public int deletePhStudyByPhStudyIds(Long[] phStudyIds) {
    phStudyMapper.deletePhStudyFileByPhStudyIds(phStudyIds);
    return phStudyMapper.deletePhStudyByPhStudyIds(phStudyIds);
  }

  /**
   * 删除党史内容学习活动信息
   *
   * @param phStudyId 党史内容学习活动主键
   * @return 结果
   */
  @Transactional
  @Override
  public int deletePhStudyByPhStudyId(Long phStudyId) {
    phStudyMapper.deletePhStudyFileByPhStudyId(phStudyId);
    return phStudyMapper.deletePhStudyByPhStudyId(phStudyId);
  }

  /**
   * 新增党史内容学习文件信息
   *
   * @param phStudy 党史内容学习活动对象
   */
  public void insertPhStudyFile(PhStudy phStudy) {
    List<PhStudyFile> phStudyFileList = phStudy.getPhStudyFileList();
    Long phStudyId = phStudy.getPhStudyId();
    if (StringUtils.isNotNull(phStudyFileList)) {
      List<PhStudyFile> list = new ArrayList<PhStudyFile>();
      for (PhStudyFile phStudyFile : phStudyFileList) {
        phStudyFile.setPhStudyId(phStudyId);
        list.add(phStudyFile);
      }
      if (list.size() > 0) {
        phStudyMapper.batchPhStudyFile(list);
      }
    }
  }
}
