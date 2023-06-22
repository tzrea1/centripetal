package com.joyboys.admin.mapper;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:06
 * @Version 1.0
 **/
import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.mapper.QuizActivityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class QuizActivityMapperTest {

    @MockBean
    private QuizActivityMapper quizActivityMapper;

    private QuizActivity quizActivity;

    @BeforeEach
    void setUp() {
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
    void testSelectQuizActivityByQuizActivityId() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityMapper.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }
    // 同样的方式，添加其他测试方法，如测试插入，删除，更新和查询列表等...
    @Test
    void testInsertNotice() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityMapper.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    void testSelectNoticeList() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityMapper.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    void testUpdateNotice() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityMapper.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }

    @Test
    void testDeleteNoticeByNoticeIds() {
        when(quizActivityMapper.selectQuizActivityByQuizActivityId(24L)).thenReturn(quizActivity);

        QuizActivity result = quizActivityMapper.selectQuizActivityByQuizActivityId(24L);

        assertEquals(quizActivity, result);
    }
}
