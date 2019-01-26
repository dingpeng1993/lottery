package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.entity.SegmentEntity;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
public interface SegmentEntityDao {
    /**
     * 插入新建的一个批次
     * @param segmentEntity
     * @return
     */
    Integer insertOne(SegmentEntity segmentEntity);

    /**
     * 插入新建的多个批次
     * @param segmentEntities
     * @return
     */
    Integer insertList(List<SegmentEntity> segmentEntities);

    /**
     * 根据id更新批次内容
     * @param segmentEntity
     * @return
     */
    Integer updateByPrimaryKey(SegmentEntity segmentEntity);

    /**
     * 根据活动id删除批次
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);


    /**
     * 根据id选择批次
     * @param id
     * @return
     */
    SegmentEntity selectByPrimaryKey(Integer id);

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