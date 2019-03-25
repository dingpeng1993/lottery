package com.dingpeng.java.exercise.lottery.resource.dal;


import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.domain.model.Segment;
import com.dingpeng.java.exercise.lottery.domain.repository.ActivityRepository;
import com.dingpeng.java.exercise.lottery.resource.dao.*;
import com.dingpeng.java.exercise.lottery.resource.entity.*;
import com.dingpeng.java.exercise.lottery.resource.factory.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dp
 * Date: 2019/2/25 10:16
 * Description: TODO
 */
@Repository
public class ActivityDal implements ActivityRepository {

    @Resource
    private ActivityEntityDao activityEntityDao;

    @Resource
    private SegmentEntityDao segmentEntityDao;

    @Resource
    private PrizeEntityDao prizeEntityDao;

    @Resource
    private PrizePoolEntityDao prizePoolEntityDao;

    @Resource
    private ConstraintEntityDao constraintEntityDao;

    @Override
    public Long save(Activity activity) {
        ActivityEntity activityEntity = ActivityFactory.transfer(activity);
        //存储活动
        activityEntityDao.insertOne(activityEntity);
        activity.setActivityId(activityEntity.getId());
        //存储活动批次
        List<SegmentEntity> segmentEntities = getSegmentEntities(activity);
        segmentEntityDao.insertList(segmentEntities);
        fillSegment(segmentEntities, activity.getSegmentList());
        //存储批次中的奖品池，奖品，以及规则
        activity.getSegmentList().forEach(segment -> {
            savePrize(segment);
            savePrizePool(activity, segment);
            saveConstraint(activity, segment);
        });
        return activityEntity.getId();
    }

    /**
     * 对活动中每个批次的规则进行存储
     * @param activity
     * @param segment
     */
    private void saveConstraint(Activity activity, Segment segment) {
        List<ConstraintEntity> constraintEntities = ConstraintFactory.transfer(segment.getConstraintList());
        constraintEntities.forEach(constraintEntity -> {
            constraintEntity.setActivityId(activity.getActivityId());
            constraintEntity.setSegmentId(segment.getSegmentId());
        });
        constraintEntityDao.insertList(constraintEntities);
    }

    /**
     * 对活动中的每个批次中的奖品池进行存储
     * @param activity
     * @param segment
     */
    private void savePrizePool(Activity activity, Segment segment) {
        List<PrizePoolEntity> prizePoolEntities = PrizePoolFactory.transfer(segment.getPrizePoolList());
        prizePoolEntities.forEach(prizePoolEntity -> {
            prizePoolEntity.setActivityId(activity.getActivityId());
            prizePoolEntity.setSegmentId(segment.getSegmentId());
        });
        prizePoolEntityDao.insertList(prizePoolEntities);
    }

    /**
     * 对活动中的每个批次中的奖品进行存储
     * @param segment
     */
    private void savePrize(Segment segment) {
        segment.getPrizePoolList().forEach(prizePool -> {
            PrizeEntity prizeEntity = PrizeFactory.transfer(prizePool.getPrize());
            prizeEntityDao.insertOne(prizeEntity);
            prizePool.getPrize().setPrizeId(prizeEntity.getId());
        });
    }

    /**
     * 设置批次Id
     * @param segmentEntities
     * @param segmentList
     */
    private void fillSegment(List<SegmentEntity> segmentEntities, List<Segment> segmentList) {
        if (segmentEntities == null || segmentList == null) {
            return;
        }
        for (int i = 0; i < segmentEntities.size(); i++) {
            segmentList.get(i).setSegmentId(segmentEntities.get(i).getId());
        }
    }

    /**
     * 设置批次的活动Id
     * @param activity
     * @return
     */
    private List<SegmentEntity> getSegmentEntities(Activity activity) {
        List<SegmentEntity> segmentEntities = SegmentFactory.transfer(activity.getSegmentList());
        segmentEntities.forEach(e -> e.setActivityId(activity.getActivityId()));
        return segmentEntities;
    }

    private List<PrizeRecordEntity> queryRecord(Long activityId, Integer currentPage, Integer pageSize){
        return null;
    }
}
