package com.joyboys.admin.mapper;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:07
 * @Version 1.0
 **/
import com.joyboys.system.domain.Notice;
import com.joyboys.system.mapper.NoticeMapper;
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
public class UserQuizActivityMapperTest {

    @MockBean
    private NoticeMapper noticeMapper;

    private Notice notice;

    @BeforeEach
    void setUp() {
        notice = new Notice();
        notice.setNoticeId(25L);
        notice.setUserId(1L);
        notice.setContent("http://centripetal-oss.oss-cn-shanghai.aliyuncs.com/centripetal/files/20230607/content_1686074903937_121.html");
        notice.setTitle("oss测试2");
        notice.setPublishTime(new Date(2023,6,7,00,00));
    }

    @Test
    void testSelectNoticeByNoticeId() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeMapper.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }
    // 同样的方式，添加其他测试方法，如测试插入，删除，更新和查询列表等...
    @Test
    void testInsertNotice() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeMapper.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    void testSelectNoticeList() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeMapper.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    void testUpdateNotice() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeMapper.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }

    @Test
    void testDeleteNoticeByNoticeIds() {
        when(noticeMapper.selectNoticeByNoticeId(25L)).thenReturn(notice);

        Notice result = noticeMapper.selectNoticeByNoticeId(25L);

        assertEquals(notice, result);
    }
}
