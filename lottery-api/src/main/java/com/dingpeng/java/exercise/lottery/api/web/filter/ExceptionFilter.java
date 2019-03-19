package com.dingpeng.java.exercise.lottery.api.web.filter;

import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import com.dingpeng.java.exercise.lottery.common.exceptions.LotteryException;
import com.dingpeng.java.exercise.lottery.common.response.BaseResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(JsonMappingException.class)
    public BaseResponse handlerException(JsonMappingException e) {
        log.error(StatusCode.JSON_FORMAT_ERROR.getCode(), e);
        return  BaseResponse.fail(StatusCode.JSON_FORMAT_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse handlerException(HttpMessageNotReadableException e) {
        log.error(StatusCode.HTTP_ACESS_ERROR.getCode(), e);
        return BaseResponse.fail(StatusCode.HTTP_ACESS_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public BaseResponse handlerException(JsonParseException e) {
        log.error(StatusCode.JSON_FORMAT_ERROR.getCode(), e);
       return BaseResponse.fail(StatusCode.JSON_FORMAT_ERROR);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public BaseResponse handlerException(InvalidFormatException e) {
        log.error(StatusCode.DATA_FORMAT_ERROR.getCode(), e);
        return BaseResponse.fail(StatusCode.DATA_FORMAT_ERROR);
    }

}
