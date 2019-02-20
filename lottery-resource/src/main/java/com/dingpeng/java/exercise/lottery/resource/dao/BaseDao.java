package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.entity.BaseEntity;

/**
 * @author dp
 * @param <E> 返回实体类型
 */
public interface BaseDao <E extends BaseEntity> {
    /**
     * 插入新建的一条数据
     * @param entity
     * @return Integer
     */
    Long insertOne(E entity);

    /**
     * 根据id更新记录内容
     * @param entity
     * @return Integer
     */
    Long updateByPrimaryKey(E entity);


    /**
     * 根据id选择
     * @param id
     * @return E
     */
    E selectByPrimaryKey(Long id);

    /**
     * 根据id删除
     * @param id
     * @return Long
     */
    Long deleteByPrimaryKey(Long id);


}
