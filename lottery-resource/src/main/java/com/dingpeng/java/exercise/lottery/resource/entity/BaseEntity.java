package com.dingpeng.java.exercise.lottery.resource.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author dp
 * @date 2019.01.21
 */

@Data
public class BaseEntity {
    /**
     * 默认主键Id
     */

    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
