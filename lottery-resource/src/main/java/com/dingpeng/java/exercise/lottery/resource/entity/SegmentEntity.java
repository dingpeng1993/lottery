package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author dp
 * @date 2019/01/21
 */

@Data
public class SegmentEntity extends BaseEntity{

    private String name;

    private String description;

    private Long activityId;

    /**
     * 批次开始时间
     */
    private Date startTime;
    /**
     * 批次结束时间
     */
    private Date endTime;
    /**
     * 批次状态
     */
    private Integer status;
}
