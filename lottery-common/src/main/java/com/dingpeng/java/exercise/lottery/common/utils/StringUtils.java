package com.dingpeng.java.exercise.lottery.common.utils;

import com.google.common.collect.Lists;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author dp
 * Date: 2019/3/5 18:15
 * Description: TODO
 */
public class StringUtils {

    public static final String LIST_BREAK = ",";
    public static final String LIST_EDGE = "[]";

    /**
     * 被“|”分两部分,^\d+$表示数字开头,数字结尾，至少要有一位数字
     */
    private static final Pattern INTEGER = Pattern.compile("^\\d+$|-\\d+$|\\+\\d+$");
    private static final Pattern FLOAT = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$|\\+\\d+\\.\\d+$");


    public static boolean isEmpty(@Nullable String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static boolean isBlank(String str){
        return isEmpty(str) && str.trim().length() > 0;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static String numListToString(List<? extends Number> list, String separator) {
        if (list == null || list.size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        list.forEach(e -> sb.append(e).append(separator));
        sb.delete(sb.length() - 1, sb.length()).append(']');
        return sb.toString();
    }

    public static  List<Integer> stringToList(String str, String separator){
        List<Integer> list  = Lists.newArrayList();
        if (isEmpty(str) || LIST_EDGE.equals(str)) {
            return list;
        }
        String[] arr = str.substring(1, str.length() - 1).split(separator);
        for(String num : arr){
            if (isInteger(num.trim())) {
                list.add(Integer.valueOf(num.trim()));
            } else {
                throw new RuntimeException("字符串中包含不是数字的单元");
            }
        }
        return list;
    }


    public static boolean isInteger(String str) {
        return INTEGER.matcher(str).matches();
    }

    public static boolean isFloat(String str){
        return FLOAT.matcher(str).matches();
    }

    public static  boolean isNum(String str){
        return isInteger(str) || isFloat(str);
    }
}
