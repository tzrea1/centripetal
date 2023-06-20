package com.joyboys.system.mapper;

import com.joyboys.system.domain.Question;
import com.joyboys.system.domain.QuizActivity;
import java.util.List;

/**
 * 答题活动Mapper接口
 *
 * @author joyboys
 * @date 2023-05-08
 */
public interface QuizActivityMapper {

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
   * 删除答题活动
   *
   * @param quizActivityId 答题活动主键
   * @return 结果
   */
  public int deleteQuizActivityByQuizActivityId(Long quizActivityId);

  /**
   * 批量删除答题活动
   *
   * @param quizActivityIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteQuizActivityByQuizActivityIds(Long[] quizActivityIds);

  /**
   * 批量删除题目
   *
   * @param quizActivityIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteQuestionByQuizActivityIds(Long[] quizActivityIds);

  /**
   * 批量新增题目
   *
   * @param questionList 题目列表
   * @return 结果
   */
  public int batchQuestion(List<Question> questionList);


  /**
   * 通过答题活动主键删除题目信息
   *
   * @param quizActivityId 答题活动ID
   * @return 结果
   */
  public int deleteQuestionByQuizActivityId(Long quizActivityId);
}
