package com.dingpeng.java.exercise.lottery.domain.repository;

import com.dingpeng.java.exercise.lottery.domain.model.Prize;

/**
 * @author dp
 * @date 2019.02.20
 */
public interface PrizeRepository {
    /**
     * 插入奖品
     * @param prize
     */
    void insert(Prize prize);
}
