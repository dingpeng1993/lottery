package com.dingpeng.java.exercise.lottery.resource.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author dp
 * @date 2019.01.21
 */
@Data
public class PrizePoolEntity extends BaseEntity{

    /**
     * 对应的活动Id
     */
    private Integer activityId;

    /**
     * 对应活动的批次Id
     */
    private Integer segmentId;


    private List<PrizeLimit> prizeList;


    @Data
    public static class PrizeLimit{
        @JsonProperty("id")
        private Integer prizeId;
        /**
         * 该奖品总数
         */
        @JsonProperty("all")
        private Integer totalNum;

        /**
         * 该奖品剩余数量
         */
        @JsonProperty("ex")
        private Integer existNum;
        /**
         * 可以中将奖品池奖品的人群Id
         */
        @JsonProperty("gid")
        private String groupIds;
    }

}
