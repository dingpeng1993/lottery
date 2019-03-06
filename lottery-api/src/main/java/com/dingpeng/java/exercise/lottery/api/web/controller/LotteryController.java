package com.dingpeng.java.exercise.lottery.api.web.controller;

import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import com.dingpeng.java.exercise.lottery.common.request.DrawRequest;
import com.dingpeng.java.exercise.lottery.common.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author dp
 */

@RestController
@Api(value = "抽奖接口", tags = "用于抽奖相关操作")
@RequestMapping("/api/lottery")
@Slf4j
public class LotteryController {

    @PostMapping("/draw")
    @ApiOperation(value = "抽奖并返回结果")
    public BaseResponse draw(@RequestBody DrawRequest drawRequest){
        return BaseResponse.create(StatusCode.SERVICE_RUN_SUCCESS, drawRequest);
    }



}
