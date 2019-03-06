package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;

/**
 * @author dp
 * @date 2019.01.21
 */
@Data
public class PrizePoolEntity extends BaseEntity{

    /**
     * 对应的活动Id
     */
    private Long activityId;

    /**
     * 对应活动的批次Id
     */
    private Long segmentId;
    /**
     * 包含的奖品ID
     */
    private Long prizeId;

    /**
     * 奖品总数
     */
    private Integer total;

    /**
     * 奖品剩余数量
     */
    private Integer exist;

    /**
     * 奖品对应人群
     */
    private String groupIds;

}
