package com.dingpeng.java.exercise.lottery.common.module;

import lombok.Data;

/**
 * @author dp
 * Date: 2019/3/14 19:21
 * Description: TODO
 */
@Data
public class DrawResultDTO {

    private Integer chance;

    private Integer extraChance;

    private PrizeDTO prizeDTO;

    public DrawResultDTO(Integer chance, Integer extraChance, PrizeDTO prizeDTO) {
        this.chance = chance;
        this.extraChance = extraChance;
        this.prizeDTO = prizeDTO;
    }

    public static DrawResultDTO getEmptyPrize(Integer chance, Integer extraChance) {
        return new DrawResultDTO(chance, extraChance, PrizeDTO.getEmptyPrize());
    }
}
