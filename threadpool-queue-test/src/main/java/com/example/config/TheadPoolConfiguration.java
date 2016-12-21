package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by ptmind on 2016/12/21.
 */
@Configuration
public class TheadPoolConfiguration {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(10);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return poolTaskExecutor;
    }

}
