package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.entity.MemberEntity;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author dp
 * Date: 2019/3/12 14:03
 * Description: TODO
 */
@Repository
public class MemberEntityDao {

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valueOperations;

    public void save(MemberEntity memberEntity){
        String key = memberEntity.getActivityId() + ":" + memberEntity.getUid();
        valueOperations.set(key, memberEntity);
    }

    public MemberEntity get(Long uid, Long activityId){
        String key = activityId+ ":" + uid;
        return (MemberEntity) valueOperations.get(key);
    }
}
