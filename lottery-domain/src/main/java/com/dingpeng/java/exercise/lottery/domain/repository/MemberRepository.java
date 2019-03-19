package com.dingpeng.java.exercise.lottery.domain.repository;

import com.dingpeng.java.exercise.lottery.domain.model.Member;

/**
 * @author dp
 * Date: 2019/3/13 15:42
 * Description: TODO
 */
public interface MemberRepository {
    /**
     * 根据id得到用户
     * @param uid
     * @param activityId
     * @return 用户类
     */
    Member get(Long uid, Long activityId);

    /**
     * 保存Member
     * @param member
     */
    void save(Member member);
}
