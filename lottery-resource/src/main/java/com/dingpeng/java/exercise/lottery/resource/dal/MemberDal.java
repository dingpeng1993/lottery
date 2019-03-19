package com.dingpeng.java.exercise.lottery.resource.dal;

import com.dingpeng.java.exercise.lottery.common.enums.MemberEnum;
import com.dingpeng.java.exercise.lottery.common.utils.StringUtils;
import com.dingpeng.java.exercise.lottery.domain.model.Member;
import com.dingpeng.java.exercise.lottery.domain.repository.MemberRepository;
import com.dingpeng.java.exercise.lottery.resource.dao.MemberEntityDao;
import com.dingpeng.java.exercise.lottery.resource.entity.MemberEntity;
import com.dingpeng.java.exercise.lottery.resource.factory.MemberFactory;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author dp
 * Date: 2019/3/13 15:52
 * Description: TODO
 */
@Repository
public class MemberDal implements MemberRepository{

    private static final Integer DEFAULT_CHANCE = 5;

    private static final Integer DEFAULT_EXTRA_CHANCE = 2;
    @Resource
    private MemberEntityDao memberEntityDao;

    @Override
    public Member get(Long uid, Long activityId) {
        MemberEntity memberEntity = memberEntityDao.get(uid, activityId);
        Member member = MemberFactory.transfer(memberEntity);
        return Optional.ofNullable(member).orElseGet(() -> createNewMember(uid, activityId));
    }

    @Override
    public void save(Member member) {
        MemberEntity memberEntity = MemberFactory.transfer(member);
        memberEntityDao.save(memberEntity);
    }


    public static Member createNewMember(Long uid, Long activityId) {
        Member member = new Member();
        member.setUid(uid);
        member.setActivityId(activityId);
        member.setGroupId(MemberEnum.NEW_USER_GROUP.getGroupId());
        member.setPhone(StringUtils.EMPTY);
        member.setChance(DEFAULT_CHANCE);
        member.setExtraChance(DEFAULT_EXTRA_CHANCE);
        member.setProb(MemberEnum.NEW_USER_GROUP.getProb());
        member.setPrizes(Lists.newArrayList());
        return member;
    }
}
