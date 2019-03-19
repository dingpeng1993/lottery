package com.dingpeng.java.exercise.lottery.resource.entity;

import com.dingpeng.java.exercise.lottery.domain.model.Prize;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dp
 * Date: 2019/3/12 14:24
 * Description: TODO
 */
@Data
public class MemberEntity implements Serializable{

    private static final long serialVersionUID = 534654767663462L;

    private Long uid;

    private Long activityId;

    private Integer groupId;

    private String phone;

    private Integer chance;

    private Integer extraChance;

    private float prob;

    private List<Prize> prizes;
}
