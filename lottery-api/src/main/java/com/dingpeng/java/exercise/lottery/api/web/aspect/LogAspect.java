package com.dingpeng.java.exercise.lottery.api.web.aspect;

import com.alibaba.fastjson.JSON;
import com.dingpeng.java.exercise.lottery.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dp
 * Date: 2019/2/21 10:15
 * Description: @Aspect定义切面类，由于该类在Spring中是作为组件，要加上@Component才能生效
 */


@Aspect
@Component
@Slf4j
public class LogAspect {

    private static HttpServletRequest request;
    /**
     * 配置切入点表达式
     */
    @Pointcut("execution(* com.dingpeng.java.exercise.lottery.api.web.controller.*.*(..))")
    public void controllerPoint(){}

    /**
     * 前置处理，记录访问日志
     * @param joinPoint
     */
    @Before("controllerPoint()")
    public void before(JoinPoint joinPoint){
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("uri={} || request={}" , request.getRequestURI(),getParams(joinPoint));
    }

    private String getParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        if(args != null){
            stringBuilder.append(JSON.toJSONString(args[0]));
        }
        return  stringBuilder.toString();
    }

    /**
     * 后置处理，记录返回
     * @param response
     */
    @AfterReturning(returning = "response", pointcut = "controllerPoint()")
    public void after(BaseResponse response){
        if (response != null && response.getData() != null) {
            log.info("uri={} || response={}", request.getRequestURI(), JSON.toJSONString(response.getData()));
        }
    }

}
