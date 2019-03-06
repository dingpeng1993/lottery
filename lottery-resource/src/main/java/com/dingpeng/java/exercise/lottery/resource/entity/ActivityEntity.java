package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author dp
 * @date 2019.01.21
 */

@Data
public class ActivityEntity extends BaseEntity {

    private String name;

    private String description;
    /**
     * 活动开始时间
     */
    private Date startTime;
    /**
     * 活动结束时间
     */
    private Date endTime;
    /**
     * 活动状态
     */
    private Integer status;

}
