package com.dingpeng.java.exercise.lottery.api.web.controller;

import com.dingpeng.java.exercise.lottery.api.web.response.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author dp
 */
@RestController
@Api(value = "抽奖接口", tags = "用于抽奖相关操作")
@RequestMapping("/api/lottery")
public class LotteryController {

    @PostMapping("/draw")
    public BaseResponse draw(){
        return null;
    }
}
