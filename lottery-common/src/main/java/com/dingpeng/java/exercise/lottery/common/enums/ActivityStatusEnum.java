package com.dingpeng.java.exercise.lottery.common.enums;

/**
 * @author dp
 * Date: 2019/3/14 20:16
 * Description: TODO
 */
public enum ActivityStatusEnum {
    /**
     * 活动正在进行中
     */
    OPEN(1, "活动正在进行中"),
    /**
     * 活动关闭
     */
    CLOSE(0, "活动尚未开始或已结束");
    private Integer status;
    private String message;

    ActivityStatusEnum(Integer status, String message){
        this.message = message;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
