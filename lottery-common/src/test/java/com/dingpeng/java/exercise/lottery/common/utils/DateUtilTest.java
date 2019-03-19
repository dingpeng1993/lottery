package com.dingpeng.java.exercise.lottery.common.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author dp
 * Date: 2019/3/15 12:21
 * Description: TODO
 */
class DateUtilTest {

    @Test
    void stampToDateTest(){
        Date date = DateUtil.parseTimeStampToDate(DateUtil.nowTimeStamp());
        System.out.println(date);
    }


}