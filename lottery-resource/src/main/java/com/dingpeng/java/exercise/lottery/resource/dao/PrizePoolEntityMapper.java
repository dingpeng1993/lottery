package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.base.entity.PrizePoolEntity;
import com.dingpeng.java.exercise.lottery.base.entity.PrizePoolEntityCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PrizePoolEntityMapper {
    int countByExample(PrizePoolEntityCriteria example);

    int deleteByExample(PrizePoolEntityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrizePoolEntity record);

    int insertSelective(PrizePoolEntity record);

    List<PrizePoolEntity> selectByExampleWithRowbounds(PrizePoolEntityCriteria example, RowBounds rowBounds);

    List<PrizePoolEntity> selectByExample(PrizePoolEntityCriteria example);

    PrizePoolEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrizePoolEntity record, @Param("example") PrizePoolEntityCriteria example);

    int updateByExample(@Param("record") PrizePoolEntity record, @Param("example") PrizePoolEntityCriteria example);

    int updateByPrimaryKeySelective(PrizePoolEntity record);

    int updateByPrimaryKey(PrizePoolEntity record);
}