package com.dingpeng.java.exercise.lottery.domain.model;

import lombok.Data;

import java.util.List;

/**
 * @author dp
 * Date: 2019/2/21 19:20
 * Description: 奖品池领域模型
 */
@Data
public class PrizePool {

    private Integer prizePoolId;

    private Integer total;

    private Integer exist;

    private Prize prize;

    private List<Integer> groupIds;
}
