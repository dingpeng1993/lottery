package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.entity.ActivityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 具体的函数实现由XxMapper.xml完成
 * @author dp
 * @date 2019.01.25
 */
public interface ActivityEntityDao {

    /**
     * 插入新建的一个活动
     * @param activityEntity
     * @return
     */
    Integer insertOne(ActivityEntity activityEntity);

    /**
     * 插入新建的多个活动
     * @param activityEntities
     * @return
     */
    Integer insertList(List<ActivityEntity> activityEntities);

    /**
     * 根据id更新活动内容
     * @param activityEntity
     * @return
     */
    Integer updateByPrimaryKey(ActivityEntity activityEntity);

    /**
     * 根据活动id删除活动
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);


    /**
     * 根据id选择活动
     * @param id
     * @return
     */
    ActivityEntity selectByPrimaryKey(Integer id);

    /**
     * 当前时间生效的活动
     * @param currentTime
     * @return
     */
    List<ActivityEntity> selectEffectiveActivity(@Param("currentTime") Date currentTime);

    /**
     * 当前时间不生效的活动
     * @param currentTime
     * @return
     */
    List<ActivityEntity> selectUnEffectiveActivity(@Param("currentTime") Date currentTime);
}