package com.dingpeng.java.exercise.lottery.biz.transfer;

import com.dingpeng.java.exercise.lottery.common.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dp
 * Date: 2019/3/5 18:01
 * Description: TODO
 */
class ActivityTransferTest {

    @Test
    void transfer() {
    }

    @Test
    @DisplayName("字符串与list的转换")
    void StringToListTest(){
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4));
        Assertions.assertEquals("[1, 2, 3, 4]", integers.toString());
        String content = "[1, 2, 3, 4]";

        Assertions.assertEquals("[]", StringUtils.numListToString(null, StringUtils.LIST_BREAK));
        Assertions.assertEquals("[]", StringUtils.numListToString(new ArrayList<>(),
                StringUtils.LIST_BREAK));
        Assertions.assertEquals("[1]",
                StringUtils.numListToString(new ArrayList<>(Collections.singletonList(1)), StringUtils.LIST_BREAK));
        Assertions.assertEquals("[1,2,3]",
                StringUtils.numListToString(new ArrayList<>(Arrays.asList(1,2,3)), StringUtils.LIST_BREAK));
        List<Integer> integerList = StringUtils.stringToList(content, StringUtils.LIST_BREAK);

        Assertions.assertArrayEquals(integers.toArray(), integerList.toArray());
    }

    @Test
    @DisplayName("判断字符串是否是数字")
    void isNumTest(){
        Assertions.assertTrue(StringUtils.isInteger("0456577"));
        Assertions.assertFalse(StringUtils.isInteger("3.1"));
        Assertions.assertFalse(StringUtils.isInteger(""));
        Assertions.assertFalse(StringUtils.isFloat("sf54"));

        Assertions.assertFalse(StringUtils.isFloat(""));
        Assertions.assertFalse(StringUtils.isFloat("35345"));
        Assertions.assertFalse(StringUtils.isFloat("s"));
        Assertions.assertTrue(StringUtils.isFloat("3.1"));
        Assertions.assertFalse(StringUtils.isFloat("3."));
        Assertions.assertFalse(StringUtils.isFloat("3.1.3"));

        Assertions.assertTrue(StringUtils.isFloat("-3.1"));
        Assertions.assertTrue(StringUtils.isFloat("+3.1"));
        Assertions.assertFalse(StringUtils.isFloat("3-1"));

        Assertions.assertTrue(StringUtils.isInteger("-3"));
        Assertions.assertTrue(StringUtils.isInteger("+3"));
        Assertions.assertFalse(StringUtils.isInteger("5-3"));
    }
}