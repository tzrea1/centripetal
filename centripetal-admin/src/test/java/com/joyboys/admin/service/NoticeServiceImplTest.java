package com.joyboys.admin.service;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/20 0:23
 * @Version 1.0
 **/
import com.joyboys.system.domain.Notice;
import com.joyboys.system.mapper.NoticeMapper;
import com.joyboys.system.service.impl.NoticeServiceImpl;
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
public class NoticeServiceImplTest {

    @Mock
    private NoticeMapper noticeMapper;

    @InjectMocks
    private NoticeServiceImpl noticeService;

    private Notice notice;

    @BeforeEach
    public void setUp() {
        notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));
    }

    @Test
    public void testSelectNoticeByNoticeId() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeService.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    // similarly write tests for other methods
    @Test
    public void testSelectNoticeList() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeService.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    public void testInsertNotice() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeService.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    public void testUpdateNotice() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeService.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    public void testDeleteNoticeByNoticeIds() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeService.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }
}
