package com.dingpeng.java.exercise.lottery.api.web.config;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dp
 * Date: 2019/3/19 15:04
 * Description: 异步任务配置，线程池
 */
public class AsyncConfig {
    private static final int CORE_POOL_SIZE = 3;

    private static final int MAX_POOL_SIZE = 10;

    private static final long KEEP_ALIVE_TIME = 60;

    private static final int MAX_QUEUE_SIZE = 1024;

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(MAX_QUEUE_SIZE), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
