package com.joyboys.admin.controller;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:06
 * @Version 1.0
 **/
import com.joyboys.system.domain.QuizActivity;
import com.joyboys.system.service.IQuizActivityService;
import com.joyboys.admin.controller.system.QuizActivityController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class QuizActivityControllerTest {

    @Mock
    private IQuizActivityService quizActivityService;

    @InjectMocks
    private QuizActivityController quizActivityController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(quizActivityController).build();
    }

    @Test
    public void testGetInfo() throws Exception {
        QuizActivity quizActivity = new QuizActivity();
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

        when(quizActivityService.selectQuizActivityByQuizActivityId(anyLong())).thenReturn(quizActivity);

        mockMvc.perform(get("/system/contest/{quizActivityId}", 24L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.quizActivityId", is(24)));

        verify(quizActivityService, times(1)).selectQuizActivityByQuizActivityId(24L);
    }

    // similarly write tests for other methods
    @Test
    public void testAdd() throws Exception {
        QuizActivity quizActivity = new QuizActivity();
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

        when(quizActivityService.selectQuizActivityByQuizActivityId(anyLong())).thenReturn(quizActivity);

        mockMvc.perform(get("/system/contest/{quizActivityId}", 24L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.quizActivityId", is(24)));

        verify(quizActivityService, times(1)).selectQuizActivityByQuizActivityId(24L);
    }

    @Test
    public void testEdit() throws Exception {
        QuizActivity quizActivity = new QuizActivity();
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

        when(quizActivityService.selectQuizActivityByQuizActivityId(anyLong())).thenReturn(quizActivity);

        mockMvc.perform(get("/system/contest/{quizActivityId}", 24L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.quizActivityId", is(24)));

        verify(quizActivityService, times(1)).selectQuizActivityByQuizActivityId(24L);
    }

    @Test
    public void testRemove() throws Exception {
        QuizActivity quizActivity = new QuizActivity();
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

        when(quizActivityService.selectQuizActivityByQuizActivityId(anyLong())).thenReturn(quizActivity);

        mockMvc.perform(get("/system/contest/{quizActivityId}", 24L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.quizActivityId", is(24)));

        verify(quizActivityService, times(1)).selectQuizActivityByQuizActivityId(24L);
    }

    @Test
    public void testList() throws Exception {
        QuizActivity quizActivity = new QuizActivity();
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

        when(quizActivityService.selectQuizActivityByQuizActivityId(anyLong())).thenReturn(quizActivity);

        mockMvc.perform(get("/system/contest/{quizActivityId}", 24L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.quizActivityId", is(24)));

        verify(quizActivityService, times(1)).selectQuizActivityByQuizActivityId(24L);
    }
}
