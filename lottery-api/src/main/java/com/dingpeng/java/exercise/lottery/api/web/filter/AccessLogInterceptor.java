package com.dingpeng.java.exercise.lottery.api.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author dp
 * Date: 2019/2/21 10:43
 * Description: 记录接口访问日志
 */

@Component
@Slf4j
@Deprecated
public class AccessLogInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        String uri = request.getRequestURI();
        String param = getParam(request);
        log.info("uri={}|| param={}", uri, param);
        return super.preHandle(request, response, handler);
    }

    /**
     * 获取request的param
     * @param request
     * @return
     */
    private String getParam(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        StringBuilder stringBuilder = new StringBuilder();
        while (paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            if (paramValue != null && !"".equals(paramValue.trim())) {
                stringBuilder.append(paramName).append("=").append(paramValue).append(";");
            }
        }
        if (stringBuilder.length() > 1) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
        return  stringBuilder.toString();
    }
}

