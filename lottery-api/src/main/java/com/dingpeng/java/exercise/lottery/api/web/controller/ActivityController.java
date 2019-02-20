package com.dingpeng.java.exercise.lottery.api.web.controller;

import com.dingpeng.java.exercise.lottery.api.web.utils.BindingResultUtil;
import com.dingpeng.java.exercise.lottery.biz.flow.ActivityFlow;
import com.dingpeng.java.exercise.lottery.common.request.SaveActivityRequest;
import com.dingpeng.java.exercise.lottery.common.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
/**
 * @author dp
 * Date: 2019/2/20 13:10
 * Description: 抽奖活动相关操作接口
 */

@RestController
@Slf4j
@RequestMapping("/api/activity")
@Api(value = "活动接口", tags = "用于增删改活动相关操作")
public class ActivityController {

    @Autowired
    private ActivityFlow activityFlow;

    @PostMapping("/save")
    @ApiOperation(value = "新建一个活动", tags = "新建一个活动，包括批次，奖品池")
    public BaseResponse save(@Valid @RequestBody SaveActivityRequest activityRequest, BindingResult result){
        //确认参数合法
        BindingResultUtil.assertParamValid(result);

        List<Long> activityIds =activityFlow.doSave(activityRequest);
        return null;
    }
}
