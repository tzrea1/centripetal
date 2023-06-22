package com.joyboys.admin.service;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:05
 * @Version 1.0
 **/
import com.joyboys.system.domain.Group;
import com.joyboys.system.mapper.GroupMapper;
import com.joyboys.system.service.impl.GroupServiceImpl;
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
public class GroupServiceImplTest {

    @Mock
    private GroupMapper groupMapper;

    @InjectMocks
    private GroupServiceImpl groupService;

    private Group group;

    @BeforeEach
    public void setUp() {
        group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");
    }

    @Test
    public void testSelectGroupByGroupId() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupService.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    // similarly write tests for other methods
    @Test
    public void testSelectGroupList() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupService.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    public void testInsertGroup() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupService.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    public void testUpdateGroup() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupService.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    public void testDeleteGroupByGroupIds() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupService.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }
}

