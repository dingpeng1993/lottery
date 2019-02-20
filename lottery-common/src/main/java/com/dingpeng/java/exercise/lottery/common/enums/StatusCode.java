package com.dingpeng.java.exercise.lottery.common.enums;

/**
 * @author dp
 *
 */

public enum StatusCode {
    /**
     * 响应状态码与代表的含义
     */
    SERVICE_RUN_SUCCESS(200, "服务运行成功"),

    PARAMEMTER_VALIDATE_ILLEGAL(10001, "参数非法:%s"),

    PARAM_IS_EMPTY(10002, "参数%s不能为空"),

    DATA_NOT_EXIST(10003, "%s不存在"),

    JSON_FORMAT_ERROR(10004, "JSON格式不正确"),

    DATA_FORMAT_ERROR(10005, "数据格式化异常"),

    HTTP_ACESS_ERROR(10006, "HTTP访问异常"),

    PARAMETER_IS_ILLEGAL(10007,"参数异常"),

    DB_ACCESS_ERROR(80000, "数据库异常:%s"),

    DB_OPERATION_ERROR(80001, "数据操作失败"),

    SERVICE_RUN_ERROR(99999, "服务器忙,请稍后再试");

    private int status;
    private String msg;

    StatusCode(int status, String msg){
        this.msg = msg;
        this.status = status;
    }

    public boolean isSuccess(){
        return status == SERVICE_RUN_SUCCESS.getStatus();
    }

    public int getStatus(){
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsg(Object... objects) {
        return msg;
    }

    public String getCode(){
        return name();
    }
}
