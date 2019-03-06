package com.dingpeng.java.exercise.lottery.resource.dao;


import com.dingpeng.java.exercise.lottery.resource.entity.PrizeEntity;
import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
public interface PrizeEntityDao extends BaseDao<PrizeEntity>{

    /**
     * 插入新建的多个奖品
     * @param prizeEntities
     * @return
     */
    Integer insertList(List<PrizeEntity> prizeEntities);

    /**
     * 根据奖品类型选择奖品
     * @param type
     * @return
     */
    List<PrizeEntity> selectByType(Integer type);
}