package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;


/**
 * @author dp
 * @date 2019.01.21
 */

@Data
public class ConstraintEntity extends BaseEntity{

    private String name;

    private Long activityId;

    private Long segmentId;
    /**
     * 约束的类型
     */
    private Integer type;
    /**
     * 约束键
     */
    private String constraintKey;
    /**
     * 约束值
     */
    private String constraintValue;

}
