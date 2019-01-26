package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.base.entity.ConstraintEntity;
import com.dingpeng.java.exercise.lottery.base.entity.ConstraintEntityCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ConstraintEntityDao {
    int countByExample(ConstraintEntityCriteria example);

    int deleteByExample(ConstraintEntityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConstraintEntity record);

    int insertSelective(ConstraintEntity record);

    List<ConstraintEntity> selectByExampleWithRowbounds(ConstraintEntityCriteria example, RowBounds rowBounds);

    List<ConstraintEntity> selectByExample(ConstraintEntityCriteria example);

    ConstraintEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConstraintEntity record, @Param("example") ConstraintEntityCriteria example);

    int updateByExample(@Param("record") ConstraintEntity record, @Param("example") ConstraintEntityCriteria example);

    int updateByPrimaryKeySelective(ConstraintEntity record);

    int updateByPrimaryKey(ConstraintEntity record);
}