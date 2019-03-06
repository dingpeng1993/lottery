package com.dingpeng.java.exercise.lottery.resource.factory;


import com.dingpeng.java.exercise.lottery.common.utils.StringUtils;
import com.dingpeng.java.exercise.lottery.domain.model.PrizePool;
import com.dingpeng.java.exercise.lottery.resource.entity.PrizePoolEntity;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author dp
 * Date: 2019/2/25 14:11
 * Description: TODO
 */
public class PrizePoolFactory {

    public static List<PrizePoolEntity> transfer(List<PrizePool> prizePoolList) {
        if (prizePoolList == null) {
            return Lists.newArrayList();
        }
        return prizePoolList.stream().filter(Objects::nonNull).map(PrizePoolFactory::transfer).collect(Collectors.toList());
    }

    public static PrizePoolEntity transfer(PrizePool prizePool){
        if (prizePool == null) {
            return null;
        }
        PrizePoolEntity prizePoolEntity = new PrizePoolEntity();
        prizePoolEntity.setExist(prizePool.getExist());
        prizePoolEntity.setTotal(prizePool.getTotal());
        prizePoolEntity.setGroupIds(StringUtils.numListToString(prizePool.getGroupIds(),StringUtils.LIST_BREAK));
        prizePoolEntity.setPrizeId(prizePool.getPrize().getPrizeId());
        return prizePoolEntity;
    }
}
