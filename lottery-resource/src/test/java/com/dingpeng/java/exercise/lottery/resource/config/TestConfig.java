package com.dingpeng.java.exercise.lottery.resource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author dp
 * Date: 2019/3/6 14:40
 * Description: @TestConfiguration的含义@Configuration之外补充测试专门用的Bean或者自定义的配置。
 * https://segmentfault.com/a/1190000010854811
 */
@TestConfiguration
public class TestConfig {
    @Bean("dataSource")
    public DataSource buildDataSource(){
        System.out.println("testDataSource被扫描到");
        DruidDataSource dataSource = new DruidDataSource();
        String lotteryDBUrl = "jdbc:mysql://localhost:3306/dingpeng?useUnicode=true&characterEncoding=UTF-8";
        dataSource.setUrl(lotteryDBUrl);
        String lotteryDBUserName = "root";
        dataSource.setUsername(lotteryDBUserName);
        String lotteryDBPassword = "123456";
        dataSource.setPassword(lotteryDBPassword);
        String driverClass = "com.mysql.cj.jdbc.Driver";
        dataSource.setDriverClassName(driverClass);
        int lotteryMinIdle = 2;
        dataSource.setInitialSize(lotteryMinIdle);
        int lotteryMaxActive = 10;
        dataSource.setMaxActive(lotteryMaxActive);
        dataSource.setMinIdle(lotteryMinIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(30000);
        dataSource.setMinEvictableIdleTimeMillis(15000);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }
}
