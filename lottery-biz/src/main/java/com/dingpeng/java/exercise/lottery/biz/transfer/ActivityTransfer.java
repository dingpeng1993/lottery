package com.dingpeng.java.exercise.lottery.biz.transfer;

import com.dingpeng.java.exercise.lottery.common.request.SaveActivityRequest;
import com.dingpeng.java.exercise.lottery.common.utils.DateUtil;
import com.dingpeng.java.exercise.lottery.common.utils.StringUtils;
import com.dingpeng.java.exercise.lottery.domain.model.*;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author dp
 * Date: 2019/2/22 14:52
 * Description: TODO
 */
public class ActivityTransfer {

    public static Activity transfer(SaveActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setName(activityRequest.getName());
        activity.setDescription(activityRequest.getDescription());
        activity.setStartTime(DateUtil.parseStringToDateTime(activityRequest.getStartTime()));
        activity.setEndTime(DateUtil.parseStringToDateTime(activityRequest.getEndTime()));
        activity.setStatus(activityRequest.getStatus());
        activity.setSegmentList(createSegmentList(activityRequest.getSegmentList()));
        return activity;
    }

    /**
     * 生成Segment列表
     * @param segmentList
     * @return
     */
    private static List<Segment> createSegmentList(List<SaveActivityRequest.Segment> segmentList) {
        if(segmentList == null){
            return Lists.newArrayList();
        }
        return segmentList.stream().filter(Objects::nonNull).map(ActivityTransfer::createSegment).collect(Collectors.toList());
    }
    private static Segment createSegment(SaveActivityRequest.Segment segmentRequest) {
        Segment segment = new Segment();
        segment.setName(segmentRequest.getName());
        segment.setDescription(segmentRequest.getDescription());
        segment.setStartTime(DateUtil.parseStringToDateTime(segmentRequest.getStartTime()));
        segment.setEndTime(DateUtil.parseStringToDateTime(segmentRequest.getEndTime()));
        segment.setStatus(segmentRequest.getStatus());
        segment.setPrizePoolList(createPrizeList(segmentRequest.getPrizeList()));
        segment.setConstraintList(createConstraintList(segmentRequest.getRuleList()));
        return segment;
    }

    /**
     * 生成rule列表
     * @param ruleList
     * @return
     */
    private static List<BaseConstraint> createConstraintList(List<SaveActivityRequest.Segment.Rule> ruleList) {
        if (ruleList == null) {
            return Lists.newArrayList();
        }
        return ruleList.stream().filter(Objects::nonNull).map(ActivityTransfer::createConstraint).collect(Collectors.toList());
    }
    private static BaseConstraint createConstraint(SaveActivityRequest.Segment.Rule rule) {
        BaseConstraint baseConstraint = new BaseConstraint();
        baseConstraint.setKey(rule.getKey());
        baseConstraint.setValue(rule.getValue());
        baseConstraint.setName(rule.getName());
        baseConstraint.setType(rule.getType());
        return baseConstraint;
    }

    /**
     * 生成奖品池列表
     * @param prizeList
     * @return
     */
    private static List<PrizePool> createPrizeList(List<SaveActivityRequest.Segment.Prize> prizeList) {
        List<PrizePool> prizePools = Lists.newArrayList();
        prizeList.stream().filter(Objects::nonNull).forEach(e ->{
            PrizePool prizePool = new PrizePool();
            prizePool.setPrize(createPrize(e));
            prizePool.setExist(e.getExist());
            prizePool.setTotal(e.getTotal());
            prizePool.setGroupIds(StringUtils.stringToList(e.getGroupIds(),StringUtils.LIST_BREAK));
            prizePools.add(prizePool);
        });
        return prizePools;
    }

    private static Prize createPrize(SaveActivityRequest.Segment.Prize e) {
        Prize prize = new Prize();
        prize.setFeature(e.getFeature());
        prize.setName(e.getName());
        prize.setType(e.getType());
        return prize;
    }
}
