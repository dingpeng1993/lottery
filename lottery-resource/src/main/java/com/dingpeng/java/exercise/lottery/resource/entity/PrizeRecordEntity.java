package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;


/**
 * @author dp
 * @date 2019.01.21
 */

@Data
public class PrizeRecordEntity extends BaseEntity{

    private Integer activityId;

    private Integer segmentId;

    private Integer userId;

    private Integer prizeId;

    private String phone;
    /**
     * 中奖进度
     */
    private Integer winSchedule;

}
