package com.dingpeng.java.exercise.lottery.resource.dao;

import com.dingpeng.java.exercise.lottery.resource.config.RedisConfig;
import com.dingpeng.java.exercise.lottery.resource.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author dp
 * Date: 2019/3/12 14:45
 * Description: TODO
 */
@SpringBootTest(classes = RedisConfig.class)
@ExtendWith(SpringExtension.class)
@DisplayName("redis的保存与读取测试")
class MemberEntityDaoTest {

    @Resource
    private MemberEntityDao memberEntityDao;
    @Test
    void save() {
        MemberEntity member = new MemberEntity();
        member.setActivityId(1L);
        member.setPhone("15757173945");
        member.setUid(563514141325L);
        memberEntityDao.save(member);
    }

    @Test
    void get() {
    }
}