package com.dingpeng.java.exercise.lottery.domain.service;

import com.dingpeng.java.exercise.lottery.domain.model.*;
import com.dingpeng.java.exercise.lottery.domain.repository.ActivityRepository;
import com.dingpeng.java.exercise.lottery.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author dp
 * Date: 2019/2/25 10:04
 * Description: TODO
 */

@Service
public class ActivityService {
    
    @Resource
    private ActivityRepository activityRepository;

    @Resource
    private MemberRepository memberRepository;
    
    public Long saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Long updateActivity(Activity activity){
        return 1L;
    }

    public Prize getPrize(Activity activity, Member member) {
        activity.join(member);
        Segment segment = activity.getCurrentSegment();
        if (Objects.nonNull(segment)) {
            List<PrizePool> prizePools = segment.getPrizePoolList();
        }

        if (activity.isWin()) {
            Prize prize = null;
        }
        memberRepository.save(member);
        return null;
    }
}
