package com.dingpeng.java.exercise.lottery.resource.factory;

import com.dingpeng.java.exercise.lottery.domain.model.Segment;
import com.dingpeng.java.exercise.lottery.resource.entity.SegmentEntity;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author dp
 * Date: 2019/2/25 10:47
 * Description: TODO
 */
public class SegmentFactory {

    public static List<SegmentEntity> transfer(List<Segment> segmentList) {
        if (segmentList == null) {
            return Lists.newArrayList();
        }
        return segmentList.stream().filter(Objects::nonNull).map(SegmentFactory::transfer).collect(Collectors.toList());
    }

    public static SegmentEntity transfer(Segment segment){
        SegmentEntity segmentEntity = new SegmentEntity();
        if (segment == null) {
            return segmentEntity;
        }
        segmentEntity.setName(segment.getName());
        segmentEntity.setDescription(segment.getDescription());
        segmentEntity.setStartTime(segment.getStartTime());
        segmentEntity.setEndTime(segment.getEndTime());
        segmentEntity.setStatus(segment.getStatus());
        return segmentEntity;
    }
}
