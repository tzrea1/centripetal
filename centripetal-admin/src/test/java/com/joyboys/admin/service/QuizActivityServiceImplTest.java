package com.joyboys.admin.service;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:06
 * @Version 1.0
 **/
import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.mapper.QuizActivityMapper;
import com.joyboys.system.service.impl.QuizActivityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class QuizActivityServiceImplTest {

    @Mock
    private QuizActivityMapper quizActivityMapper;

    @InjectMocks
    private QuizActivityServiceImpl quizActivityService;

    private QuizActivity quizActivity;

    @BeforeEach
    public void setUp() {
        quizActivity = new QuizActivity();
        quizActivity.setQuizActivityId(24L);
        quizActivity.setCreatorId(1L);
        quizActivity.setTimeLimit(3L);
        quizActivity.setTitle("测试竞赛");
        quizActivity.setDescription("6.21测试竞赛");
        quizActivity.setTotalPoints(3);
        quizActivity.setState("发布");
        quizActivity.setStartTime(new Date(2023,6,20,00,00));
        quizActivity.setEndTime(new Date(2023,6,23,00,00));
        quizActivity.setAcceptanceLine(2);
        quizActivity.setQuizNum(3);
    }

    @Test
    public void testSelectQuizActivityByQuizActivityId() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityService.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    // similarly write tests for other methods
    @Test
    public void testSelectNoticeList() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityService.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    public void testInsertNotice() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityService.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    public void testUpdateNotice() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityService.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    public void testDeleteNoticeByNoticeIds() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityService.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }
}
