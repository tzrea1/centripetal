package com.joyboys.system.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.domain.Question;
import com.joyboys.system.mapper.QuizActivityMapper;
import com.joyboys.system.util.StringToDateConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;




class QuizActivityServiceImplTest {

  @InjectMocks
  QuizActivityServiceImpl quizActivityService;

  @Mock
  QuizActivityMapper quizActivityMapper;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  static Stream<Arguments> provideQuestionsFromCSV() throws IOException {
    List<Arguments> argumentsList = new ArrayList<>();
    try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/resources/questions.csv"))) {
      String line;
      while((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        String content = "NULL".equals(values[0]) || values[0].trim().isEmpty() ? null : values[0];
        Integer questionScore = "NULL".equals(values[1]) || values[1].trim().isEmpty() ? null : Integer.valueOf(values[1]);
        String options = "NULL".equals(values[2]) || values[2].trim().isEmpty() ? null : values[2];
        String correctAnswer = "NULL".equals(values[3]) || values[3].trim().isEmpty() ? null : values[3];
        String questionType = "NULL".equals(values[4]) || values[4].trim().isEmpty() ? null : values[4];
        Integer result = "NULL".equals(values[5]) || values[5].trim().isEmpty() ? null : Integer.valueOf(values[5]);
        Long quizActivityId = 1L;  // Assuming that quizActivityId is always 1L
        QuizActivity quizActivity = new QuizActivity();
        Question question = new Question(quizActivityId, content, questionScore, correctAnswer, options, questionType);
        argumentsList.add(Arguments.of(Collections.singletonList(question), result));
      }
    }
    return argumentsList.stream();
  }


  @ParameterizedTest
  @CsvFileSource(resources = "/quizActivity.csv")
  void insertQuizActivity(String title, Long timeLimit, String description, Integer totalPoints, String state, @ConvertWith(StringToDateConverter.class) Date startTime, @ConvertWith(StringToDateConverter.class) Date endTime, Integer acceptanceLine, Integer quizNum, Integer result) {
    Long userId= 1L;
    String actualTitle = "NULL".equals(title) ? null : title;
    String actualDescription = "NULL".equals(description) ? null : description;
    String actualState = "NULL".equals(state) ? null : state;
    QuizActivity quizActivity = new QuizActivity(userId, actualTitle, timeLimit, actualDescription, totalPoints, actualState, startTime, endTime, acceptanceLine, quizNum);
    // Assuming that quizActivityMapper.insertQuizActivity will return result
    int mapperResult = 1;
    if(actualTitle==null||actualDescription==null||actualState==null||timeLimit==null||totalPoints==null||startTime==null||endTime==null||acceptanceLine==null||quizNum==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(quizActivityMapper.insertQuizActivity(quizActivity)).thenReturn(mapperResult);

    int insertResult = quizActivityService.insertQuizActivity(quizActivity);
    boolean test = quizActivity.isValid();
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/quizActivity.csv")
  void updateQuizActivity(String title, Long timeLimit, String description, Integer totalPoints, String state, @ConvertWith(StringToDateConverter.class) Date startTime, @ConvertWith(StringToDateConverter.class) Date endTime, Integer acceptanceLine, Integer quizNum, Integer result) {
    Long userId= 1L;
    String actualTitle = "NULL".equals(title) ? null : title;
    String actualDescription = "NULL".equals(description) ? null : description;
    String actualState = "NULL".equals(state) ? null : state;
    QuizActivity quizActivity = new QuizActivity(userId, actualTitle, timeLimit, actualDescription, totalPoints, actualState, startTime, endTime, acceptanceLine, quizNum);
    // Assuming that quizActivityMapper.insertQuizActivity will return result
    int mapperResult = 1;
    if(actualTitle==null||actualDescription==null||actualState==null||timeLimit==null||totalPoints==null||startTime==null||endTime==null||acceptanceLine==null||quizNum==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(quizActivityMapper.updateQuizActivity(quizActivity)).thenReturn(mapperResult);

    int updateResult = quizActivityService.updateQuizActivity(quizActivity);
    if (result == 1) {
      assertTrue(updateResult > 0);
    } else {
      assertEquals(result, updateResult);
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/question.csv")
  void insertQuestion(String content, Integer questionScore, String options, String correctAnswer,String questionType, Integer result)
      throws ParseException {
    Long quizActivityId= 1L;
    String actualContent = "NULL".equals(content) ? null : content;
    String actualOptions = "NULL".equals(options) ? null : options;
    String actualCorrectAnswer = "NULL".equals(correctAnswer) ? null : correctAnswer;
    String actualQuestionType = "NULL".equals(questionType) ? null : questionType;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startTime = dateFormat.parse("2023-06-15");
    Date endTime = dateFormat.parse("2023-06-16");

    QuizActivity quizActivity = new QuizActivity(1L, "test", 10L, "test", 1, "发布", startTime, endTime, 1, 1);

    Question question = new Question(quizActivityId, actualContent, questionScore, actualCorrectAnswer, actualOptions, actualQuestionType);
    List<Question> list = new ArrayList<>();
    list.add(question);
    quizActivity.setQuestionList(list);

    // Assuming that quizActivityMapper.insertQuizActivity will return result
    int mapperResult = 1;
    if(list.get(0).getContent() ==null||list.get(0).getQuestionScore()==null||list.get(0).getCorrectAnswer()==null||list.get(0).getOptions()==null||list.get(0).getQuestionType()==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(quizActivityMapper.batchQuestion(quizActivity.getQuestionList())).thenReturn(mapperResult);

    int insertResult = quizActivityService.insertQuestion(quizActivity);
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }

  @ParameterizedTest
  @MethodSource("provideQuestionsFromCSV")
  void insertQuestions(List<Question> questionList, Integer result) {
    QuizActivity quizActivity = new QuizActivity();
    quizActivity.setQuestionList(questionList);
    quizActivity.setTotalPoints(3);
    // Assuming that quizActivityMapper.insertQuizActivity will return result
    int mapperResult = 1;
    for(Question question: questionList){
      if(question.getContent() ==null||question.getQuestionScore()==null||question.getCorrectAnswer()==null||question.getOptions()==null||question.getQuestionType()==null){
        mapperResult=-100; // 表示数据库错误
        break;
      }
    }
    when(quizActivityMapper.batchQuestion(quizActivity.getQuestionList())).thenReturn(mapperResult);

    int insertResult = quizActivityService.insertQuestion(quizActivity);
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }
}
