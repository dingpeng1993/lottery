package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;


/**
 * @author dp
 * @date 2019.01.21
 */
@Data
public class PrizeEntity extends BaseEntity{

    private String name;

    /**
     * 奖品类型
     */
    private Integer type;

    private String feature;

}
