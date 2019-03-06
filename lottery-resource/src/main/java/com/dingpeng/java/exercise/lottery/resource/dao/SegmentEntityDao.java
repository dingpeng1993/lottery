package com.dingpeng.java.exercise.lottery.resource.dao;


import com.dingpeng.java.exercise.lottery.resource.entity.SegmentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
public interface SegmentEntityDao extends BaseDao<SegmentEntity> {


    /**
     * 插入新建的多个批次
     * @param segmentEntities
     * @return
     */
    Integer insertList(List<SegmentEntity> segmentEntities);


    /**
     * 当前时间生效的批次
     * @param currentTime
     * @return
     */
    List<SegmentEntity> selectEffectiveSegment(@Param("currentTime") Date currentTime);

    /**
     * 当前时间不生效的批次
     * @param currentTime
     * @return
     */
    List<SegmentEntity> selectUnEffectiveSegment(@Param("currentTime") Date currentTime);
}