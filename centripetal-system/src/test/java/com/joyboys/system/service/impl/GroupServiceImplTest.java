package com.joyboys.system.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.joyboys.system.domain.Group;
import com.joyboys.system.mapper.GroupMapper;
import com.joyboys.system.util.StringToDateConverter;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class GroupServiceImplTest {

  @InjectMocks
  GroupServiceImpl groupService;

  @Mock
  GroupMapper groupMapper;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/group.csv")
  void insertGroup(String description, String groupname, int result) {
    Long creatorId= 1L;
    String actualDescription = "NULL".equals(description) ? null : description;
    String actualGroupname = "NULL".equals(groupname) ? null : groupname;
    Group group = new Group(null,creatorId,actualDescription,actualGroupname);

    // Assuming that groupMapper.insertGroup will return result
    int mapperResult = 1;
    if(actualDescription==null||actualGroupname==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(groupMapper.insertGroup(group)).thenReturn(mapperResult);

    int insertResult = groupService.insertGroup(group);
    if (result == 1) {
      assertTrue(insertResult > 0);
    } else {
      assertEquals(result, insertResult);
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/group.csv")
  void updateGroup(String description, String groupname,int result) {
    Long userId= 1L;
    String actualDescription = "NULL".equals(description) ? null : description;
    String actualGroupname = "NULL".equals(groupname) ? null : groupname;
    Group group = new Group(null,userId,actualDescription,actualGroupname);

    // Assuming that groupMapper.updateGroup will return result
    int mapperResult = 1;
    if(actualDescription==null||actualGroupname==null){
      mapperResult=-100; // 表示数据库错误
    }
    when(groupMapper.updateGroup(group)).thenReturn(mapperResult);

    int updateResult = groupService.updateGroup(group);
    if (result == 1) {
      assertTrue(updateResult > 0);
    } else {
      assertEquals(result, updateResult);
    }
  }
}
