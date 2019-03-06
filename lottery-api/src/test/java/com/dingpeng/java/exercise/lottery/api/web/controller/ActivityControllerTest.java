package com.dingpeng.java.exercise.lottery.api.web.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author dp
 * Date: 2019/3/5 17:19
 * Description: 集成测试 MockMvc实现对Http请求的模拟
 */
@SpringBootTest("ApplicationStarter.class")
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
class ActivityControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeAll
    void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}