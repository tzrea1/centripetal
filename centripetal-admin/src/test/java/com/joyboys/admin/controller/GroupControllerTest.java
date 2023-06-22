package com.joyboys.admin.controller;

/**
 * @Description TODO
 * @Author MXY
 * @Date 2023/6/22 0:05
 * @Version 1.0
 **/
import com.joyboys.system.domain.Group;
import com.joyboys.system.service.IGroupService;
import com.joyboys.admin.controller.system.GroupController;
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
public class GroupControllerTest {

    @Mock
    private IGroupService groupService;

    @InjectMocks
    private GroupController groupController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    public void testGetInfo() throws Exception {
        Group group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");

        when(groupService.selectGroupByGroupId(anyLong())).thenReturn(group);

        mockMvc.perform(get("/system/group/{groupId}", 6L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.groupId", is(6)));

        verify(groupService, times(1)).selectGroupByGroupId(6L);
    }

    // similarly write tests for other methods
    @Test
    public void testAdd() throws Exception {
        Group group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");

        when(groupService.selectGroupByGroupId(anyLong())).thenReturn(group);

        mockMvc.perform(get("/system/group/{groupId}", 6L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.groupId", is(6)));

        verify(groupService, times(1)).selectGroupByGroupId(6L);
    }

    @Test
    public void testEdit() throws Exception {
        Group group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");

        when(groupService.selectGroupByGroupId(anyLong())).thenReturn(group);

        mockMvc.perform(get("/system/group/{groupId}", 6L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.groupId", is(6)));

        verify(groupService, times(1)).selectGroupByGroupId(6L);
    }

    @Test
    public void testRemove() throws Exception {
        Group group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");

        when(groupService.selectGroupByGroupId(anyLong())).thenReturn(group);

        mockMvc.perform(get("/system/group/{groupId}", 6L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.groupId", is(6)));

        verify(groupService, times(1)).selectGroupByGroupId(6L);
    }

    @Test
    public void testList() throws Exception {
        Group group = new Group();
        group.setGroupId(6L);
        group.setCreatorId(1L);
        group.setDescription("wajZ8juwye");
        group.setGroupname("Ku Chiu Wai");

        when(groupService.selectGroupByGroupId(anyLong())).thenReturn(group);

        mockMvc.perform(get("/system/group/{groupId}", 6L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.groupId", is(6)));

        verify(groupService, times(1)).selectGroupByGroupId(6L);
    }
}
