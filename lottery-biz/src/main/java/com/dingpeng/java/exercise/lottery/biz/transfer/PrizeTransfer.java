package com.dingpeng.java.exercise.lottery.biz.transfer;

import com.dingpeng.java.exercise.lottery.common.module.PrizeDTO;
import com.dingpeng.java.exercise.lottery.domain.model.Prize;

import java.util.Objects;

/**
 * @author dp
 * Date: 2019/3/14 19:56
 * Description: TODO
 */
public class PrizeTransfer {

    public static PrizeDTO transfer(Prize prize) {
        if (Objects.isNull(prize)) {
            return PrizeDTO.getEmptyPrize();
        }
        return new PrizeDTO(prize.getPrizeId(), prize.getName());
    }

}
