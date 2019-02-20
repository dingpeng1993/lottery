package com.dingpeng.java.exercise.lottery.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author dp
 * Date: 2019/2/20 13:21
 * Description: TODO
 */

@Data
public class SaveActivityRequest {

    @ApiModelProperty(notes = "活动名称")
    @NotBlank(message = "活动名称不能为空")
    private String name;

    @ApiModelProperty(notes = "活动描述")
    @NotBlank(message = "活动描述不能为空")
    private String description;

    @NotBlank(message = "活动开始时间不能为空")
    private String startTime;

    @NotBlank(message = "活动结束时间不能为空")
    private String endTime;

    @Range(min = 0, max = 2, message = "活动状态 0为停止，1为开始，2为暂停")
    private Integer status;

    @Valid
    @NotEmpty(message = "活动批次不能为空")
    private List<Segment> segmentList;

    @Data
    public static class Segment{
        @NotBlank(message = "批次名称不能为空")
        private String name;

        @NotBlank(message = "批次描述不能为空")
        private String description;

        @NotBlank(message = "批次开始时间不能为空")
        private String startTime;

        @NotBlank(message = "批次结束时间不能为空")
        private String endTime;

        @Range(min = 0, max = 2, message = "批次状态 0为停止，1为开始，2为暂停")
        private Integer status;

        @Valid
        @NotEmpty(message = "活动中的奖品不能为空")
        private List<Prize> prizeList;

        @Valid
        @NotEmpty(message = "规则列表不能为空")
        private List<Rule> ruleList;
    }

    @Data
    public static class Prize{

        @NotBlank(message = "奖品名称不能为空")
        private String name;

        @NotBlank(message = "奖品特性不能为空")
        private String feature;

        @Range(min = 1, max = 4, message = "1为实物，2为券，3为奖励金，4为码")
        private Integer type;

        @NotEmpty(message = "可中奖用户Id不能为空")
        private List<Integer> groupIds;
    }


    @Data
    public static class Rule{
        @NotBlank(message = "奖励规则名称不能为空")
        private String name;

        @Range(min = 1, max = 2, message = "规则范围：1为准入规则， 2为奖励规则")
        private Integer type;

        @NotBlank(message = "规则键不能为空")
        private String key;

        @NotBlank(message = "规则值不能为空")
        private String value;
    }
}
