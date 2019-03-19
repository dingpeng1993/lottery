package com.dingpeng.java.exercise.lottery.resource.dao;


import com.dingpeng.java.exercise.lottery.resource.entity.PrizePoolEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dp
 * @date 2019.01.25
 */
@Mapper
public interface PrizePoolEntityDao extends BaseDao<PrizePoolEntity>{
    /**
     * 插入新建的多个奖品
     * @param prizePoolEntities
     * @return
     */
    Integer insertList(List<PrizePoolEntity> prizePoolEntities);


}