package com.dingpeng.java.exercise.lottery.common.request;

import lombok.Data;

/**
 * @author dp
 * Date: 2019/2/20 13:02
 * Description: 抽奖请求
 */
@Data
public class DrawRequest {

    /**
     * 活动Id
     */
    private String activityId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户角色
     */
    private Integer role;

}
