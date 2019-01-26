package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.base.entity.PrizeRecordEntity;
import com.dingpeng.java.exercise.lottery.base.entity.PrizeRecordEntityCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PrizeRecordEntityMapper {
    int countByExample(PrizeRecordEntityCriteria example);

    int deleteByExample(PrizeRecordEntityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrizeRecordEntity record);

    int insertSelective(PrizeRecordEntity record);

    List<PrizeRecordEntity> selectByExampleWithRowbounds(PrizeRecordEntityCriteria example, RowBounds rowBounds);

    List<PrizeRecordEntity> selectByExample(PrizeRecordEntityCriteria example);

    PrizeRecordEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrizeRecordEntity record, @Param("example") PrizeRecordEntityCriteria example);

    int updateByExample(@Param("record") PrizeRecordEntity record, @Param("example") PrizeRecordEntityCriteria example);

    int updateByPrimaryKeySelective(PrizeRecordEntity record);

    int updateByPrimaryKey(PrizeRecordEntity record);
}