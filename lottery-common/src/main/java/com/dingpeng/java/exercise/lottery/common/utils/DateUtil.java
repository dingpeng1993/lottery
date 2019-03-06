package com.dingpeng.java.exercise.lottery.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dp
 * Date: 2019/2/22 14:57
 * Description: java新增的日期类https://www.jianshu.com/p/a5651396c192
 */
public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String DATETIME_PATTERN =  "yyyy-MM-dd HH:mm:ss";

    public static  Date parseStringToDateTime(String dateStr){
        return parse(dateStr, DATETIME_PATTERN);
    }

    public static Date parseStringToDate(String dateStr){
        return parse(dateStr, DATE_PATTERN);
    }

    private static Date parse(String dateStr, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
           throw new RuntimeException("日期转换出错:" + e);
        }
    }
}
