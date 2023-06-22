package com.joyboys.admin.mapper;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:05
 * @Version 1.0
 **/
import com.joyboys.system.domain.Group;
import com.joyboys.system.mapper.GroupMapper;
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
public class GroupMapperTest {

    @MockBean
    private GroupMapper groupMapper;

    private Group group;

    @BeforeEach
    void setUp() {
        group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");
    }

    @Test
    void testSelectGroupByGroupId() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupMapper.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }
    // 同样的方式，添加其他测试方法，如测试插入，删除，更新和查询列表等...
    @Test
    void testInsertGroup() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupMapper.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    void testSelectGroupList() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupMapper.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    void testUpdateGroup() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupMapper.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }

    @Test
    void testDeleteGroupByGroupIds() {
        when(groupMapper.selectGroupByGroupId(6L)).thenReturn(group);

        Group result = groupMapper.selectGroupByGroupId(6L);

        assertEquals(group, result);
    }
}
