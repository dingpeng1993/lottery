package com.dingpeng.java.exercise.lottery.domain.model;

import lombok.Data;

/**
 * @author : dp
 * Date: 2019/2/20 12:29
 * Description: Prize的领域对象
 */

@Data
public class Prize {

    private Long prizeId;

    private String name;

    private Integer type;

    private String feature;
}
