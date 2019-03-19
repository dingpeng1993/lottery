package com.dingpeng.java.exercise.lottery.domain.handler;

import com.dingpeng.java.exercise.lottery.domain.model.Member;
import com.dingpeng.java.exercise.lottery.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dp
 * Date: 2019/3/13 15:49
 * Description: TODO
 */
@Service
public class MemberQueryHandler {
    @Resource
    private MemberRepository memberRepository;

    public Member query(Long uid, Long activityId){
        return memberRepository.get(uid, activityId);
    }
}
