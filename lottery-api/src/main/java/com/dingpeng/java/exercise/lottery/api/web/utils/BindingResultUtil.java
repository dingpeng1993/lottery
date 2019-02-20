package com.dingpeng.java.exercise.lottery.api.web.utils;

import com.dingpeng.java.exercise.lottery.common.enums.StatusCode;
import com.dingpeng.java.exercise.lottery.common.exceptions.LotteryException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author dp
 * Date: 2019/2/20 15:29
 * Description: 校验参数合法性
 */
public class BindingResultUtil {
    /**
     * 断言参数合法
     */

    public static void assertParamValid(BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                throw new LotteryException(StatusCode.PARAMETER_IS_ILLEGAL, fieldError.getDefaultMessage());
            });
            throw new LotteryException(StatusCode.PARAMETER_IS_ILLEGAL, "非法参数");
        }
    }
}
