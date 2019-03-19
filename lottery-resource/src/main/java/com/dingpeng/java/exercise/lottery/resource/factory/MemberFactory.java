package com.dingpeng.java.exercise.lottery.resource.factory;

import com.dingpeng.java.exercise.lottery.common.exceptions.LotteryException;
import com.dingpeng.java.exercise.lottery.domain.model.Member;
import com.dingpeng.java.exercise.lottery.resource.entity.MemberEntity;

import java.util.Objects;

/**
 * @author dp
 * Date: 2019/3/13 15:58
 * Description: TODO
 */
public class MemberFactory {

    public static Member transfer(MemberEntity memberEntity) {
        if (Objects.isNull(memberEntity)) {
            return null;
        }
        Member member = new Member();
        member.setUid(memberEntity.getUid());
        member.setActivityId(memberEntity.getActivityId());
        member.setGroupId(memberEntity.getGroupId());
        member.setPhone(memberEntity.getPhone());
        member.setChance(memberEntity.getChance());
        member.setExtraChance(memberEntity.getExtraChance());
        member.setProb(memberEntity.getProb());
        member.setPrizes(memberEntity.getPrizes());
        return member;
    }

    public static MemberEntity transfer(Member member) {
        if (Objects.isNull(member)) {
            throw new LotteryException("保存Member不能为空");
        }
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUid(member.getUid());
        memberEntity.setActivityId(member.getActivityId());
        memberEntity.setGroupId(member.getGroupId());
        memberEntity.setPhone(member.getPhone());
        memberEntity.setChance(member.getChance());
        memberEntity.setExtraChance(member.getExtraChance());
        memberEntity.setProb(member.getProb());
        memberEntity.setPrizes(member.getPrizes());
        return memberEntity;
    }
}
