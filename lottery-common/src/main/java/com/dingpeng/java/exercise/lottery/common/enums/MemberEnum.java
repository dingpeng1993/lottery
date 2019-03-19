package com.dingpeng.java.exercise.lottery.common.enums;

/**
 * @author dp
 * Date: 2019/3/13 16:24
 * Description: TODO
 */

public enum MemberEnum {
    /**
     * 普通用户组别与概率
     */
    DEFAULT_GROUP(1, 0.3f, "普通用户"),

    /**
     * VIP用户组别与概率
     */
    VIP_GROUP(2, 0.7f, "VIP用户"),

    /**
     * 新用户组别与概率
     */
    NEW_USER_GROUP(3, 0.6f, "新用户");
    private Integer groupId;

    private Float prob;

    private String description;

    MemberEnum(Integer groupId, Float prob, String description){
        this.description = description;
        this.groupId = groupId;
        this.prob = prob;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Float getProb() {
        return prob;
    }

    public String getDescription() {
        return description;
    }
}
