package com.joyboys.system.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.joyboys.system.domain.Notice;
import com.joyboys.system.mapper.NoticeMapper;
import com.joyboys.system.util.StringToDateConverter;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class NoticeServiceImplTest {

  @InjectMocks
  NoticeServiceImpl noticeService;

  @Mock
  NoticeMapper noticeMapper;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/notice.csv")
  void insertNotice(String content, String title, @ConvertWith(StringToDateConverter.class) Date publishTime, int result) {
    Long userId= 1L;
    String actualContent = "NULL".equals(content) ? null : content;
    String actualTitle = "NULL".equals(title) ? null : title;
    Notice notice = new Notice(null,userId,actualContent,actualTitle,publishTime);

    // Assuming that noticeMapper.insertNotice will return result
    int mapperResult = 1;
    if(actualContent==null||actualTitle==null||publishTime==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(noticeMapper.insertNotice(notice)).thenReturn(mapperResult);

    int insertResult = noticeService.insertNotice(notice);
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/notice.csv")
  void updateNotice(String content, String title, @ConvertWith(StringToDateConverter.class) Date publishTime, int result) {
    Long userId= 1L;
    String actualContent = "NULL".equals(content) ? null : content;
    String actualTitle = "NULL".equals(title) ? null : title;
    Notice notice = new Notice(null,userId,actualContent,actualTitle,publishTime);
    // Assuming that noticeMapper.updateNotice will return result
    int mapperResult = 1;
    if(actualContent==null||actualTitle==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(noticeMapper.updateNotice(notice)).thenReturn(mapperResult);

    int updateResult = noticeService.updateNotice(notice);
    if (result == 1) {
      assertTrue(updateResult > 0);
    } else {
      assertEquals(result, updateResult);
    }
  }
}
