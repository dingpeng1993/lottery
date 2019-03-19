package com.dingpeng.java.exercise.lottery.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author dp
 * Date: 2019/3/15 13:21
 * Description: TODO
 */
class TimeUtilsTest {

    @Test
    void nowTime() {
        System.out.println(new Date().getTime());
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalTime time = LocalTime.now();
        System.out.println("时间是：" + time);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Test
     void adjustTimeTest(){
        int today = TimeUtils.builder().nowDateTime().getDayOfMonth();
        int firstDay = TimeUtils.builder().withFirstDayOfMonth().getDayOfMonth();
        Assertions.assertNotEquals(today, firstDay);

        LocalTime time = TimeUtils.builder().withFirstDayOfMonth().getDateTime().toLocalTime();
        Assertions.assertEquals(LocalTime.now(), time);

        LocalDateTime lastMillsOfDay = TimeUtils.builder().withLastNanoOfDay().getDateTime();
        LocalDateTime fisrtMillsOfDay = TimeUtils.builder().withFirstNanoOfDay().getDateTime();
    }
}