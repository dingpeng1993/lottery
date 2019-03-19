package com.dingpeng.java.exercise.lottery.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;


/**
 * @author dp
 * Date: 2019/3/15 12:05
 * Description: java新增的日期类https://www.cnblogs.com/comeboo/p/5378922.html
 * Instant代替Date,LocalDateTime代替Calendar, DateTimeFormatter代替SimpleDateFormat
 *
 * LocalDate,LocalTime,LocalDateTime这些类不依赖于时区展示日期和时间的值，他们依赖于系统的时间去获取日期和时间的值。
 * LocalDateTime -
 * LocalDate -
 * LocalTIme -
 *
 * SQL -> Java
 * date -> LocalDate
 * time -> LocalTime
 * timestamp -> LocalDateTime
 */
public class TimeUtils {

    /**
     * 日期
     */
    public static final String DEFAULT_FORMAT_DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 具体时刻
     */
    public static final String DEFAULT_FORMAT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private TimeUtils(){
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        /**
         * 一周从星期一开始，第一周至少四天。
         * 注意当一月的第一周天数< 4时，那么这些天会被当做第0周
         */
        private static TemporalField ISO_WEEKFIELDS = WeekFields.ISO.dayOfWeek();

        private LocalDateTime dateTime;

        /**
         * 当前时间
         * @return Builder
         */
        public Builder nowDateTime(){
            dateTime =  LocalDateTime.now();
            return this;
        }

        /**
         * Date转换为LocalDateTime
         * @param date
         * @return
         */
        public Builder dateToLocalDateTime(Date date){
            dateTime =  Optional.ofNullable(date).map(e -> e.toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDateTime()).orElse(null);
            return this;
        }

        /**
         * 将字符串日期 YYYY-MM-dd转换为LocalDateTime
         * @param dateStr
         * @return
         */
        public Builder parseDate(String dateStr){
            return parse(dateStr, DEFAULT_FORMAT_DATE_PATTERN);
        }

        /**
         * 将字符串日期 YYYY-MM-DD HH:mm:ss转换为LocalDateTime
         * @param dateStr
         * @return LocalDateTime
         */
        public Builder parseDateTime(String dateStr){
           return parse(dateStr, DEFAULT_FORMAT_DATETIME_PATTERN);
        }

        /**
         * 按一定格式转换字符串至DateTime
         * @param dateStr
         * @param pattern
         * @return
         */
        public  Builder parse(String dateStr, String pattern) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
            DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(df)
                    //将字段的默认值附加到格式化程序以用于解析
                    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                    .toFormatter();
            dateTime = LocalDateTime.parse(dateStr, formatter);
            return this;
        }

        /**
         * 增加年份
         * @param years
         * @return
         */
        public Builder plusYears(int years){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (years == 0) {
                return this;
            }
            dateTime = dateTime.plusYears(years);
            return this;
        }

        /**
         * 增加月份
         * @param months
         * @return
         */
        public Builder plusMonths(int months){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (months == 0) {
                return this;
            }
            dateTime = dateTime.plusMonths(months);
            return this;
        }

        /**
         * 增加星期
         * @param weeks
         * @return
         */
        public Builder plusWeeks(int weeks){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (weeks == 0) {
                return this;
            }
            dateTime = dateTime.plusWeeks(weeks);
            return this;
        }

        /**
         * 增加天数
         * @param days
         * @return
         */
        public Builder plusDays(int days){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (days == 0) {
                return this;
            }
            dateTime = dateTime.plusDays(days);
            return this;
        }

        /**
         * 增加小时
         * @param hours
         * @return
         */
        public Builder plusHours(int hours){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (hours == 0) {
                return this;
            }
            dateTime = dateTime.plusHours(hours);
            return this;
        }

        /**
         * 增加分钟
         * @param minutes
         * @return
         */
        public Builder plusMinutes(int minutes){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (minutes == 0) {
                return this;
            }
            dateTime = dateTime.plusMinutes(minutes);
            return this;
        }

        /**
         * 增加秒数
         * @param seconds
         * @return
         */
        public Builder plusSeconds(int seconds){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (seconds == 0) {
                return this;
            }
            dateTime = dateTime.plusSeconds(seconds);
            return this;
        }

        /**
         * 指定年份
         *
         * @param year
         * @return
         */
        public Builder withYear(int year) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withYear(year);
            return this;
        }

        /**
         * 指定月份
         *
         * @param month
         * @return
         */
        public Builder withMonth(int month) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withMonth(month);
            return this;
        }

        /**
         * 指定一年中的周数
         *
         * @param week
         * @return
         */
        public Builder withWeekOfYear(int week) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            dateTime = dateTime.with(weekFields.weekOfYear(), week);
            return this;
        }

        /**
         * 指定月份中的日期
         *
         * @param dayOfMonth
         * @return
         */
        public Builder withDayOfMonth(int dayOfMonth) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withDayOfMonth(dayOfMonth);
            return this;
        }

        /**
         * 指定一天中的小时
         *
         * @param hourOfDay
         * @return
         */
        public Builder withHourOfDay(int hourOfDay) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withHour(hourOfDay);
            return this;
        }

        /**
         * 得到当月的第一天,后面时间不会变
         * @return
         */
        public Builder withFirstDayOfMonth(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            // TemporalAdjuster调整日期
            dateTime = dateTime.with(TemporalAdjusters.firstDayOfMonth());
            return this;
        }

        /**
         * 一周的第一天，星期一为第一天
         * @return
         */
        public Builder withFirstDayOfWeek(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.with(ISO_WEEKFIELDS, 1);
           return this;
        }

        /**
         * 指定小时中的分钟
         *
         * @param minuteOfHour
         * @return
         */
        public Builder withMinuteOfHour(int minuteOfHour) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withMinute(minuteOfHour);
            return this;
        }

        /**
         * 指定分钟的秒数
         *
         * @param secondOfMinute
         * @return
         */
        public Builder withSecondOfMinute(int secondOfMinute) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withSecond(secondOfMinute);
            return this;
        }

        /**
         * 指定毫秒数
         *
         * @param millisOfSecond
         * @return
         */
        public Builder withMillisOfSecond(int millisOfSecond) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.with(ChronoField.MILLI_OF_SECOND, millisOfSecond);
            return this;
        }

        /**
         * 指定年月日时分秒毫秒
         * @return
         */
        public Builder with(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute, int milliOfSecond) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withYear(year)
                    .withMonth(monthOfYear)
                    .withDayOfMonth(dayOfMonth)
                    .withHour(hourOfDay)
                    .withMinute(minuteOfHour)
                    .withSecond(secondOfMinute)
                    .with(ChronoField.MILLI_OF_SECOND, milliOfSecond);
            return this;
        }

        /**
         * 指定年月日
         * @return Builder
         */
        public Builder with(int year, int monthOfYear, int dayOfMonth) {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.withYear(year)
                    .withMonth(monthOfYear)
                    .withDayOfMonth(dayOfMonth);
            return this;
        }

        /**
         * 一周的最后一天，星期日为第七天
         * @return
         */
        public Builder withLastDayOfWeek(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.with(ISO_WEEKFIELDS, 7);
            return this;
        }

        /**
         * 一天的最后一纳秒
         * 23:59:59 999999999
         * @return
         */
        public Builder withLastNanoOfDay() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.with(LocalTime.MAX);
            return this;
        }

        /**
         * 一天的第0秒
         * 00:00
         * @return
         */
        public Builder withFirstNanoOfDay() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            dateTime = dateTime.with(LocalTime.MIN);
            return this;
        }

        /**
         * 返回对应毫秒的LocalDateTime
         * @param millSeconds
         * @return
         */
        public static LocalDateTime millToDateTime(long millSeconds){
            Instant instant = Instant.ofEpochMilli(millSeconds);
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }

        /**
         * 获取年份
         * @return
         */
        public int getYear(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getYear();
        }

        /**
         * 获取月份
         * @return
         */
        public int getMonth(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getMonthValue();
        }

        /**
         * 获取日期在一年中的多少天
         *
         * @return
         */
        public int getDayOfYear(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getDayOfYear();
        }

        /**
         * 获取该日是当月的第几天
         * @return
         */
        public int getDayOfMonth(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getDayOfMonth();
        }

        /**
         * 获取该日是当周的第几天
         * @return
         */
        public int geyDayOfWeek(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.get(ISO_WEEKFIELDS);
        }

        /**
         * 获取日期中的小时
         *
         * @return
         */
        public int getHourOfDay() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getHour();
        }

        /**
         * 获取日期中的分钟
         *
         * @return
         */
        public int getMinuteOfHour() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getMinute();
        }

        /**
         * 获取日期中的秒
         *
         * @return
         */
        public int getSecondOfMinute() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.getSecond();
        }

        /**
         * 获取日期中的毫秒
         *
         * @return
         */
        public int getMillsOfSecond() {
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.get(ChronoField.MILLI_OF_SECOND);
        }

        /**
         * 获取当前日期
         * @return
         */
        public Date getDate(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        }

        /**
         * 获取当前日期毫秒数
         * @return 毫秒
         */
        public long getMills(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }

        /**
         * 获取当前日期秒数
         * @return
         */
        public long getSeconds(){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            return dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
        }

        /**
         * 转化为yyyy-MM-dd字符串日期格式
         * @return
         */
        public String formatDate(){
            return format(DEFAULT_FORMAT_DATE_PATTERN);
        }

        /**
         * 转化为yyyy-MM-dd HH:mm:ss字符串日期格式
         * @return
         */
        public String formatDateTime(){
            return format(DEFAULT_FORMAT_DATETIME_PATTERN);
        }

        /**
         * 按照指定日期格式化
         * @param pattern
         * @return
         */
        public String format(String pattern){
            if (Objects.isNull(dateTime)) {
                nowDateTime();
            }
            if (StringUtils.isNotEmpty(pattern)) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault());
                return ZonedDateTime.of(dateTime, ZoneId.systemDefault()).format(dateTimeFormatter);
            }
            return StringUtils.EMPTY;
        }

        /**
         * 返回dateTime
         * @return
         */
        public LocalDateTime getDateTime(){
            return dateTime;
        }

    }


}
