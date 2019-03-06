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

    private Integer chance;

    private Integer extraChance;

    private List<Prize> prizes;
}
