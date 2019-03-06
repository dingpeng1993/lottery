package com.dingpeng.java.exercise.lottery.resource.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描MyBatis的Mapper接口
 * @author dp
 * @date 2019.01.25
 * 注意，由于MapperScannerConfigurer执行的比较早，所以必须有@AutoConfigureAfter(MybatisConfig.class)
 */

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.dingpeng.java.exercise.lottery.resource.dao");
        return configurer;
    }
}
