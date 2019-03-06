package com.dingpeng.java.exercise.lottery.common.response;


import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import lombok.Data;

/**
 * @author dp
 * @date 2018-01-17
 */
@Data
public class BaseResponse<T>  {
    private boolean success;

    private int status;

    private String msg;

    private T data;

    public BaseResponse(){
    }

    public BaseResponse(T data){
        setStatus(StatusCode.SERVICE_RUN_SUCCESS.getStatus());
        setMsg(StatusCode.SERVICE_RUN_SUCCESS.getMsg());
        setData(data);
        setSuccess(true);
    }

    public BaseResponse(T data, int status, String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
        success = status == StatusCode.SERVICE_RUN_SUCCESS.getStatus();
    }

    public BaseResponse(int status, String msg){
        this.status = status;
        this.msg = msg;
        success = status == StatusCode.SERVICE_RUN_SUCCESS.getStatus();
    }

    public static<T> BaseResponse<T> create(StatusCode statusCode, T data){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(statusCode.getStatus());
        baseResponse.setMsg(statusCode.getMsg());
        baseResponse.setData(data);
        baseResponse.setSuccess(statusCode.isSuccess());
        return baseResponse;
    }
    public static <T> BaseResponse<T> success(T data){
        return create(StatusCode.SERVICE_RUN_SUCCESS, data);
    }

    public static <T> BaseResponse<T> fail(StatusCode statusCode, String message){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setStatus(statusCode.getStatus());
        baseResponse.setSuccess(statusCode.isSuccess());
        baseResponse.setMsg(String.format(statusCode.getMsg(),message));
        baseResponse.setData(null);
        return baseResponse;
    }

    public static <T> BaseResponse<T> fail(StatusCode statusCode){
        return fail(statusCode, "");
    }

    public static <T> BaseResponse<T> fail( int status, String message){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setData(null);
        baseResponse.setMsg(message);
        baseResponse.setSuccess(false);
        baseResponse.setStatus(status);
        return baseResponse;
    }

}
