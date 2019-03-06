package com.dingpeng.java.exercise.lottery.api.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import com.dingpeng.java.exercise.lottery.common.request.DrawRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author dp
 * Date: 2019/3/6 15:44
 * Description: 使用MockMvc对我们的系统的Controller进行模拟请求测试
 */

@SpringBootTest("ApplicationStarter.class")
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@Transactional
class LotteryControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void draw() throws Exception {
        DrawRequest drawRequest = new DrawRequest();
        drawRequest.setActivityId("75753253");
        drawRequest.setRole(1);
        drawRequest.setUserId("q4364765868");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/lottery/draw")
                .contentType(MediaType.APPLICATION_JSON)
                .header("uid", "3097971665604608")
                .content(JSONObject.toJSONString(drawRequest))
        ).andDo(MockMvcResultHandlers.print()).andReturn();
        Assertions.assertEquals(StatusCode.SERVICE_RUN_SUCCESS.getStatus(), result.getResponse().getStatus());
    }
}