package com.dingpeng.java.exercise.lottery.api.web.config;

import com.dingpeng.java.exercise.lottery.api.web.filter.AccessLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author dp
 * Date: 2019/2/21 11:04
 * Description: 拦截器配置
 */
//@Configuration
@Deprecated
public class FilterConfig extends WebMvcConfigurationSupport {

    @Autowired
    private AccessLogInterceptor accessLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        addAccessLogInterceptor(registry);
    }

    /**
     * 添加访问日志拦截器
     * @param registry
     */
    private void addAccessLogInterceptor(InterceptorRegistry registry) {
        MappedInterceptor mappedInterceptor = new MappedInterceptor(new String[]{"/api/**"}, accessLogInterceptor);
        registry.addInterceptor(mappedInterceptor);
    }
}
