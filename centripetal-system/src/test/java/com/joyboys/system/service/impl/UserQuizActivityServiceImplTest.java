package com.joyboys.system.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.joyboys.system.domain.UserQuizActivity;
import com.joyboys.system.mapper.UserQuizActivityMapper;
import com.joyboys.system.util.StringToDateConverter;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class UserQuizActivityServiceImplTest {

  @InjectMocks
  UserQuizActivityServiceImpl userQuizActivityService;

  @Mock
  UserQuizActivityMapper userQuizActivityMapper;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/userQuizActivity.csv")
  void insertUserQuizActivity(Integer gotScores, String activityState, @ConvertWith(StringToDateConverter.class) Date startTime,@ConvertWith(StringToDateConverter.class) Date endTime, String isPassed, int result) {
    Long userId= 1L;
    String actualActivityState = "NULL".equals(activityState) ? null : activityState;
    String actualIsPassed = "NULL".equals(isPassed) ? null : isPassed;
    UserQuizActivity userQuizActivity = new UserQuizActivity(userId,null,gotScores,startTime,endTime,actualActivityState,actualIsPassed);

    // Assuming that userQuizActivityMapper.insertUserQuizActivity will return result
    int mapperResult = 1;
    if(actualActivityState==null||gotScores==null||startTime==null||endTime==null||actualIsPassed==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(userQuizActivityMapper.insertUserQuizActivity(userQuizActivity)).thenReturn(mapperResult);

    int insertResult = userQuizActivityService.insertUserQuizActivity(userQuizActivity);
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/userQuizActivity.csv")
  void updateUserQuizActivity(Integer gotScores, String activityState, @ConvertWith(StringToDateConverter.class) Date startTime,@ConvertWith(StringToDateConverter.class) Date endTime, String isPassed, int result) {
    Long userId= 1L;
    String actualActivityState = "NULL".equals(activityState) ? null : activityState;
    String actualIsPassed = "NULL".equals(isPassed) ? null : isPassed;
    UserQuizActivity userQuizActivity = new UserQuizActivity(userId,null,gotScores,startTime,endTime,actualActivityState,actualIsPassed);

    // Assuming that userQuizActivityMapper.updateUserQuizActivity will return result
    int mapperResult = 1;
    if(actualActivityState==null||gotScores==null||startTime==null||endTime==null||actualIsPassed==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(userQuizActivityMapper.updateUserQuizActivity(userQuizActivity)).thenReturn(mapperResult);

    int updateResult = userQuizActivityService.updateUserQuizActivity(userQuizActivity);
    if (result == 1) {
      assertTrue(updateResult > 0);
    } else {
      assertEquals(result, updateResult);
    }
  }
}
