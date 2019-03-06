package com.dingpeng.java.exercise.lottery.domain.model;

import lombok.Data;


import java.util.Date;
import java.util.List;

/**
 * @author dp
 * Date: 2019/2/21 16:43
 * Description: TODO
 */

@Data
public class Activity {

    private Long activityId;

    private String name;

    private String description;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private List<Segment> segmentList;

    private Member member;
}
