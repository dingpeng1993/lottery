package com.dingpeng.java.exercise.lottery.resource.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


import javax.sql.DataSource;

/**
 * 参考：https://blog.csdn.net/isea533/article/details/50359390
 * Mybatis 基础配置类
 * @author dp
 * @date 2019.01.25
 * 开启注解事务管理
 * 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
 */

@Configuration
@EnableTransactionManagement
@Slf4j
public class MybatisConfig implements TransactionManagementConfigurer{

    @Autowired
    private DataSource dataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactory buildSqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //添加mapper的xml路径
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("MybatisConfig Exception:{}",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 在SqlSessionFactory中取出SqlSessionTemplate对象,
     * 负责管理Mybatis的sqlSession
     * @return sqlSessionTemplate
     */
    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 在拥有多个事务管理器的情况下默认使用的事务管理器
     * @return platformTransactionManager
     */
    @Bean("transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
