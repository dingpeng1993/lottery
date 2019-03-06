package com.dingpeng.java.exercise.lottery.domain.model;

import lombok.Data;

/**
 * @author dp
 * Date: 2019/2/21 19:23
 * Description: TODO
 */
@Data
public  class BaseConstraint {

    private String name;

    private Integer type;

    private String key;

    private String value;
    /**
     * 编码
     */
   void encode(){};

    /**
     * 解码
     */
    void decode(){};

}
