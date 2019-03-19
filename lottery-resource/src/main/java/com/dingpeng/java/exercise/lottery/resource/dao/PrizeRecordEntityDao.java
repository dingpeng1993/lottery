package com.dingpeng.java.exercise.lottery.resource.dao;


import com.dingpeng.java.exercise.lottery.resource.entity.PrizeRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
@Mapper
public interface PrizeRecordEntityDao extends BaseDao<PrizeRecordEntity>{

    /**
     * 根据条件查询中间记录
     * @param userId
     * @param activityId
     * @param segmentId
     * @param prizeId
     * @return
     */
    List<PrizeRecordEntity> selectByCondition(@Param("userId") Long userId, @Param("activityId") Integer activityId,
                                              @Param("segmentId") Integer segmentId, @Param("prizeId") Integer prizeId);


}