package com.dingpeng.java.exercise.lottery.domain.model;

import lombok.Data;

import java.util.List;

/**
 * @author dp
 * Date: 2019/2/22 14:46
 * Description: TODO
 */
@Data
public class Member {

    private Long uid;

    private Long activityId;

    private Integer groupId;

    private String phone;

    private Integer chance;

    private Integer extraChance;

    private float prob;

    private Boolean isHit;

    private Prize hitPrize;

    private List<Prize> prizes;

    public boolean noChance() {
        return !hasChance();
    }

    public boolean hasChance(){
        return chance > 0;
    }

    public boolean denyEnter() {
        //之后可能会有位置校验导致不符合准入条件
        return noChance();
    }
}
