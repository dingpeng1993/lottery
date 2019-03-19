package com.dingpeng.java.exercise.lottery.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


/**
 * @author dp
 * Date: 2019/2/22 14:57
 * Description: 存在线程安全问题
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
        //SimpleDateFormat线程不安全，不能用static
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                return format.parse(dateStr);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public static Date parseTimeStampToDate(long timeStamp){
        return new Date(timeStamp);
    }

    public static Long nowTimeStamp(){
        return System.currentTimeMillis();
    }

    public static Date nowDate(){
        return new Date();
    }

    public static String format(Date date){
        return Optional.ofNullable(date).map(e -> new SimpleDateFormat(DATE_PATTERN).format(e)).orElse(StringUtils.EMPTY);
    }

    public static String format(Long timeStamp, String pattern){
        return Optional.ofNullable(timeStamp).map(e -> new SimpleDateFormat(pattern).format(e)).orElse(StringUtils.EMPTY);
    }
}
