package com.dingpeng.java.exercise.lottery.api.web.filter;

import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import com.dingpeng.java.exercise.lottery.common.exceptions.LotteryException;
import com.dingpeng.java.exercise.lottery.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dp
 * Date: 2019/2/21 15:11
 * Description: @ControllerAdvice 注解拦截异常并统一处理,
 * 异常会被具体的异常类所捕获
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionFilter {

    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e){
        log.error(StatusCode.SERVICE_RUN_ERROR.getCode(),e);
        return BaseResponse.fail(StatusCode.SERVICE_RUN_ERROR);
    }

    @ExceptionHandler(LotteryException.class)
    public BaseResponse handlerLotteryException(LotteryException e){
        log.error(e.getErrorCode(), e.getErrorMessage());
        return BaseResponse.fail( e.getStatus(), e.getErrorMessage());
    }
}
