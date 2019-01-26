package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.entity.ConstraintEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
public interface ConstraintEntityDao extends BaseDao<ConstraintEntity>{

    /**
     * 查找对应活动批次的约束条件
     * @param activityId
     * @param segmentId
     * @return
     */
    List<ConstraintEntity> selectUsefulConstraint(@Param("activityId") Integer activityId,  @Param("segmentId") Integer segmentId);
}