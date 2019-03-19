package com.dingpeng.java.exercise.lottery.common.module;

import lombok.Data;

/**
 * @author dp
 * Date: 2019/3/14 19:18
 * Description: TODO
 */
@Data
public class PrizeDTO {

    private static final Long EMPTY_PRIZE_ID = -1L;

    private Long prizeId;

    private String prizeName;

    public PrizeDTO(Long prizeId, String prizeName){
        this.prizeId = prizeId;
        this.prizeName = prizeName;
    }
    public static PrizeDTO getEmptyPrize() {
        return new PrizeDTO(EMPTY_PRIZE_ID, "未中奖");
    }
}
