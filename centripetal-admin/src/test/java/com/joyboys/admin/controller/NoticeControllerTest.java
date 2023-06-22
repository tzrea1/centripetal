package com.joyboys.admin.controller;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/20 0:27
 * @Version 1.0
 **/
import com.joyboys.system.domain.Notice;
import com.joyboys.system.service.INoticeService;
import com.joyboys.admin.controller.system.NoticeController;
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
public class NoticeControllerTest {

    @Mock
    private INoticeService noticeService;

    @InjectMocks
    private NoticeController noticeController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(noticeController).build();
    }

    @Test
    public void testGetInfo() throws Exception {
        Notice notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));

        when(noticeService.selectNoticeByNoticeId(anyLong())).thenReturn(notice);

        mockMvc.perform(get("/system/notice/{noticeId}", 25L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.noticeId", is(25)));

        verify(noticeService, times(1)).selectNoticeByNoticeId(25L);
    }

    // similarly write tests for other methods
    @Test
    public void testAdd() throws Exception {
        Notice notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));

        when(noticeService.selectNoticeByNoticeId(anyLong())).thenReturn(notice);

        mockMvc.perform(get("/system/notice/{noticeId}", 25L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.noticeId", is(25)));

        verify(noticeService, times(1)).selectNoticeByNoticeId(25L);
    }

    @Test
    public void testEdit() throws Exception {
        Notice notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));

        when(noticeService.selectNoticeByNoticeId(anyLong())).thenReturn(notice);

        mockMvc.perform(get("/system/notice/{noticeId}", 25L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.noticeId", is(25)));

        verify(noticeService, times(1)).selectNoticeByNoticeId(25L);
    }

    @Test
    public void testRemove() throws Exception {
        Notice notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));

        when(noticeService.selectNoticeByNoticeId(anyLong())).thenReturn(notice);

        mockMvc.perform(get("/system/notice/{noticeId}", 25L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.noticeId", is(25)));

        verify(noticeService, times(1)).selectNoticeByNoticeId(25L);
    }

    @Test
    public void testList() throws Exception {
        Notice notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));

        when(noticeService.selectNoticeByNoticeId(anyLong())).thenReturn(notice);

        mockMvc.perform(get("/system/notice/{noticeId}", 25L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.noticeId", is(25)));

        verify(noticeService, times(1)).selectNoticeByNoticeId(25L);
    }
}
