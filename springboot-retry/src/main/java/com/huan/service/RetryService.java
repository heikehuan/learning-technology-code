package com.huan.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/9/19 - 17:42
 */
public interface RetryService {

    @Retryable(value= {NullPointerException.class},maxAttempts = 5,backoff = @Backoff(delay = 1000,multiplier = 1))
    void restryTest();

    @Recover
    void recover(NullPointerException e);
}
