package com.joyboys.system.service.impl;

import com.joyboys.common.utils.StringUtils;
import com.joyboys.system.domain.Question;
import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.mapper.QuizActivityMapper;
import com.joyboys.system.service.IQuizActivityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 答题活动Service业务层处理
 *
 * @author joyboys
 * @date 2023-05-08
 */
@Service
public class QuizActivityServiceImpl implements IQuizActivityService {

  @Autowired
  private QuizActivityMapper quizActivityMapper;

  /**
   * 查询答题活动
   *
   * @param quizActivityId 答题活动主键
   * @return 答题活动
   */
  @Override
  public QuizActivity selectQuizActivityByQuizActivityId(Long quizActivityId) {
    return quizActivityMapper.selectQuizActivityByQuizActivityId(quizActivityId);
  }

  /**
   * 查询答题活动列表
   *
   * @param quizActivity 答题活动
   * @return 答题活动
   */
  @Override
  public List<QuizActivity> selectQuizActivityList(QuizActivity quizActivity) {
    return quizActivityMapper.selectQuizActivityList(quizActivity);
  }

  /**
   * 新增答题活动
   *
   * @param quizActivity 答题活动
   * @return 结果
   */
  @Transactional
  @Override
  public int insertQuizActivity(QuizActivity quizActivity) {
    if(quizActivity.isValid()){
      int rows = quizActivityMapper.insertQuizActivity(quizActivity);
      insertQuestion(quizActivity);
      return rows;
    }
    else{
      return -1;
    }
  }

  /**
   * 修改答题活动
   *
   * @param quizActivity 答题活动
   * @return 结果
   */
  @Transactional
  @Override
  public int updateQuizActivity(QuizActivity quizActivity) {
    if(quizActivity.isValid()){
      quizActivityMapper.deleteQuestionByQuizActivityId(quizActivity.getQuizActivityId());
      insertQuestion(quizActivity);
      return quizActivityMapper.updateQuizActivity(quizActivity);
    }
    else{
      return -1;
    }
  }

  /**
   * 批量删除答题活动
   *
   * @param quizActivityIds 需要删除的答题活动主键
   * @return 结果
   */
  @Transactional
  @Override
  public int deleteQuizActivityByQuizActivityIds(Long[] quizActivityIds) {
    quizActivityMapper.deleteQuestionByQuizActivityIds(quizActivityIds);
    return quizActivityMapper.deleteQuizActivityByQuizActivityIds(quizActivityIds);
  }

  /**
   * 删除答题活动信息
   *
   * @param quizActivityId 答题活动主键
   * @return 结果
   */
  @Transactional
  @Override
  public int deleteQuizActivityByQuizActivityId(Long quizActivityId) {
    quizActivityMapper.deleteQuestionByQuizActivityId(quizActivityId);
    return quizActivityMapper.deleteQuizActivityByQuizActivityId(quizActivityId);
  }

  /**
   * 新增题目信息
   *
   * @param quizActivity 答题活动对象
   */
  public int insertQuestion(QuizActivity quizActivity) {
    if(quizActivity.isValid()){
      List<Question> questionList = quizActivity.getQuestionList();
      Long quizActivityId = quizActivity.getQuizActivityId();
      int result=0;
      if (StringUtils.isNotNull(questionList)) {
        List<Question> list = new ArrayList<Question>();
        for (Question question : questionList) {
          question.setQuizActivityId(quizActivityId);
          list.add(question);
        }
        if (list.size() > 0) {
          result = quizActivityMapper.batchQuestion(list);
        }
      }
      return result;
    }
    else{
      return -1;
    }
  }
}
