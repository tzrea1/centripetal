package com.joyboys.system.service;

import com.joyboys.system.domain.QuizActivity;
import java.util.List;

/**
 * 答题活动Service接口
 *
 * @author joyboys
 * @date 2023-05-08
 */
public interface IQuizActivityService {

  /**
   * 查询答题活动
   *
   * @param quizActivityId 答题活动主键
   * @return 答题活动
   */
  public QuizActivity selectQuizActivityByQuizActivityId(Long quizActivityId);

  /**
   * 查询答题活动列表
   *
   * @param quizActivity 答题活动
   * @return 答题活动集合
   */
  public List<QuizActivity> selectQuizActivityList(QuizActivity quizActivity);

  /**
   * 新增答题活动
   *
   * @param quizActivity 答题活动
   * @return 结果
   */
  public int insertQuizActivity(QuizActivity quizActivity);

  /**
   * 修改答题活动
   *
   * @param quizActivity 答题活动
   * @return 结果
   */
  public int updateQuizActivity(QuizActivity quizActivity);

  /**
   * 批量删除答题活动
   *
   * @param quizActivityIds 需要删除的答题活动主键集合
   * @return 结果
   */
  public int deleteQuizActivityByQuizActivityIds(Long[] quizActivityIds);

  /**
   * 删除答题活动信息
   *
   * @param quizActivityId 答题活动主键
   * @return 结果
   */
  public int deleteQuizActivityByQuizActivityId(Long quizActivityId);
}
