package com.dingpeng.java.exercise.lottery.resource.factory;

import com.dingpeng.java.exercise.lottery.domain.model.Prize;
import com.dingpeng.java.exercise.lottery.resource.entity.PrizeEntity;

/**
 * @author dp
 * Date: 2019/2/25 14:58
 * Description: TODO
 */
public class PrizeFactory {

    public static PrizeEntity transfer(Prize prize) {
        if (prize == null) {
            return null;
        }
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setFeature(prize.getFeature());
        prizeEntity.setName(prize.getName());
        prizeEntity.setType(prize.getType());
        return prizeEntity;
    }
}
