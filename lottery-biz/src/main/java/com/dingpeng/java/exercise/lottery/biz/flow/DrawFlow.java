package com.dingpeng.java.exercise.lottery.biz.flow;

import com.dingpeng.java.exercise.lottery.biz.transfer.PrizeTransfer;
import com.dingpeng.java.exercise.lottery.common.module.DrawResultDTO;
import com.dingpeng.java.exercise.lottery.common.module.PrizeDTO;
import com.dingpeng.java.exercise.lottery.common.request.DrawRequest;
import com.dingpeng.java.exercise.lottery.domain.handler.ActivityQueryHandler;
import com.dingpeng.java.exercise.lottery.domain.handler.MemberQueryHandler;
import com.dingpeng.java.exercise.lottery.domain.model.Activity;
import com.dingpeng.java.exercise.lottery.domain.model.Member;
import com.dingpeng.java.exercise.lottery.domain.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dp
 * Date: 2019/3/13 15:39
 * Description: TODO
 */
@Service
public class DrawFlow {
    @Resource
    private MemberQueryHandler memberQueryHandler;

    @Resource
    private ActivityQueryHandler activityQueryHandler;

    @Resource
    private ActivityService activityService;

    public DrawResultDTO doDraw(DrawRequest drawRequest) {
        Member member = memberQueryHandler.query(drawRequest.getUserId(), drawRequest.getActivityId());
        if (member.denyEnter()) {
            return DrawResultDTO.getEmptyPrize(member.getChance(), member.getExtraChance());
        }
        Activity activity = activityQueryHandler.getActivity(drawRequest.getActivityId());
        PrizeDTO prizeDTO = PrizeTransfer.transfer(activityService.getPrize(activity, member));
        return new DrawResultDTO(member.getChance(), member.getExtraChance(), prizeDTO);
    }
}
