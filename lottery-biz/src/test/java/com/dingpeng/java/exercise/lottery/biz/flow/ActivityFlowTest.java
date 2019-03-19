package com.dingpeng.java.exercise.lottery.biz.flow;

import com.dingpeng.java.exercise.lottery.common.request.SaveActivityRequest;
import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.domain.service.ActivityService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author dp
 * Date: 2019/3/6 16:37
 * Description: Mockito资料https://blog.csdn.net/bboyfeiyu/article/details/52127551
 */

@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito打桩测试")
class ActivityFlowTest {
    /**
     * @Mock注解的对象是@InjectMocks注解对象里的成员变量，@Mock完成成员变量的注入工作。
     * @Spy与@Mock的区别在于Spy声明的对象，对函数的调用均执行真正部分。
     * 而Mock声明的对象，对函数的调用均执行mock（即虚假函数），不执行真正部分。
     */
    @InjectMocks
    private ActivityFlow activityFlow = new ActivityFlow();

    @Mock
    private ActivityService activityService;

    private SaveActivityRequest saveActivityRequest;

    @BeforeEach
    void init(){
       saveActivityRequest = createSaveRequest();
    }

    private SaveActivityRequest createSaveRequest() {
        SaveActivityRequest saveActivityRequest = new SaveActivityRequest();
        saveActivityRequest.setDescription("flow层测试的活动描述");
        saveActivityRequest.setName("flow层测试活动名字");
        saveActivityRequest.setStartTime("2018-01-05 00:00:00");
        saveActivityRequest.setEndTime("2019-01-05 00:00:00");
        saveActivityRequest.setStatus(1);
        saveActivityRequest.setSegmentList(Lists.newArrayList());
        return saveActivityRequest;
    }

    @Test
    void doSaveTest() {
        //打桩，要在saveActivity函数执行前打好桩,当执行saveActivity函数时返回1
        when(activityService.saveActivity(any())).thenReturn(1L);
        activityFlow.doSave(saveActivityRequest);
        //验证函数从没执行过
        verify(activityService, never()).updateActivity(any());
        //验证函数被执行过一次
        verify(activityService, times(1)).saveActivity(any());
        //判断该参数值的函数是否被执行过
        verify(activityService, never()).saveActivity(new Activity());
    }
}