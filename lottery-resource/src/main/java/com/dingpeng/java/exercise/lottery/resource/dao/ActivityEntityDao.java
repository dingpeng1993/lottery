package com.dingpeng.java.exercise.lottery.resource.dao;


import com.dingpeng.java.exercise.lottery.resource.entity.ActivityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 具体的函数实现由XxMapper.xml完成
 * @author dp
 * @date 2019.01.25
 */
@Mapper
public interface ActivityEntityDao extends BaseDao<ActivityEntity> {

    /**
     * 插入新建的多个活动
     * @param activityEntities
     * @return
     */
    Integer insertList(List<ActivityEntity> activityEntities);

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