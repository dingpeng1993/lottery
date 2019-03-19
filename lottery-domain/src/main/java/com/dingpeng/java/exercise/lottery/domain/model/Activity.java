package com.dingpeng.java.exercise.lottery.domain.model;

import com.dingpeng.java.exercise.lottery.common.enums.ActivityStatusEnum;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

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

    public void join(Member member) {
        this.member = member;
    }

    public boolean isWin() {
        return ThreadLocalRandom.current().nextFloat() < this.member.getProb();
    }

    public Segment getCurrentSegment() {
        if (CollectionUtils.isEmpty(segmentList)) {
            return null;
        }
        return segmentList.stream().filter(Objects::nonNull).filter(segment ->
                segment.getStatus().equals(ActivityStatusEnum.OPEN.getStatus())
                        && segment.getStartTime().before(new Date())
                        && segment.getEndTime().after(new Date())
        ).findFirst().orElseGet(null);
    }
}
