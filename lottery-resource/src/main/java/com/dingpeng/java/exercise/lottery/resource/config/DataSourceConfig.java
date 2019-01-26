package com.dingpeng.java.exercise.lottery.resource.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author dp
 * @date 2019.01.24
 */

@Configuration
public class DataSourceConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${db.url}")
    private String lotteryDBUrl;

    @Value("${db.username}")
    private String lotteryDBUserName;

    @Value("${db.password}")
    private String lotteryDBPassword;

    /**
     * 数据库连接池的最大数据库连接数
     */
    @Value("${db.maxActive}")
    private int lotteryMaxActive;

    /**
     * 允许的最小空闲连接数，当高峰期过后，连接使用的少了，但是连接池还是会为你留着minIdle的连接。
     */
    @Value("${db.minIdle}")
    private int lotteryMinIdle;


    @Bean("dataSource")
    public DataSource buildDataSource(){
        // 数据库连接池
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(lotteryDBUrl);
        dataSource.setUsername(lotteryDBUserName);
        dataSource.setPassword(lotteryDBPassword);
        dataSource.setDriverClassName(driverClass);

        //池启动时创建的连接数量
        dataSource.setInitialSize(lotteryMinIdle);

        dataSource.setMaxActive(lotteryMaxActive);
        dataSource.setMinIdle(lotteryMinIdle);

        //当TestWhileIdle为true，每过timeBetweenEvictionRunsMillis时间，就会启动一个线程，校验连接池中闲置时间超过minEvictableIdleTimeMillis的连接对象
        dataSource.setTimeBetweenEvictionRunsMillis(30000);
        dataSource.setMinEvictableIdleTimeMillis(15000);
        // 用于验证数据库连接的有效性，mysql的验证语句是select，其他的数据库可能不同
        dataSource.setValidationQuery("select 1");
        //连接空闲时是否进行有效性验证（即是否还和数据库连通的）
        dataSource.setTestWhileIdle(true);
        //取得连接时是否进行有效性验证（即是否还和数据库连通的）
        dataSource.setTestOnBorrow(false);
        //返回连接时是否进行有效性验证（即是否还和数据库连通的）
        dataSource.setTestOnReturn(false);

        return dataSource;
    }

}
