package com.dingpeng.java.exercise.lottery.common.exceptions;

import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import lombok.Data;

/**
 * @author dp
 * Date: 2019/2/20 15:37
 * Description: TODO
 */
@Data
public class LotteryException extends RuntimeException{

    private String errorCode;

    private String errorMessage;

    private int status;

    public LotteryException(String errorCode, String errorMessage,int status) {
        super(errorCode + ":" + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public LotteryException(StatusCode statusCode) {
        this(statusCode.getCode() ,statusCode.getMsg(), statusCode.getStatus());
    }


    public LotteryException(StatusCode statusCode, Object... args) {
        this(statusCode.getCode(),statusCode.getMsg(args),statusCode.getStatus());
    }

    public LotteryException(String errorMessage){
        super(errorMessage);
    }

}
