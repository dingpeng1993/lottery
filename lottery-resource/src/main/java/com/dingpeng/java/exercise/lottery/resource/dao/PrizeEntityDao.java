package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.base.entity.PrizeEntity;
import com.dingpeng.java.exercise.lottery.base.entity.PrizeEntityCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PrizeEntityDao {
    int countByExample(PrizeEntityCriteria example);

    int deleteByExample(PrizeEntityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrizeEntity record);

    int insertSelective(PrizeEntity record);

    List<PrizeEntity> selectByExampleWithRowbounds(PrizeEntityCriteria example, RowBounds rowBounds);

    List<PrizeEntity> selectByExample(PrizeEntityCriteria example);

    PrizeEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrizeEntity record, @Param("example") PrizeEntityCriteria example);

    int updateByExample(@Param("record") PrizeEntity record, @Param("example") PrizeEntityCriteria example);

    int updateByPrimaryKeySelective(PrizeEntity record);

    int updateByPrimaryKey(PrizeEntity record);
}