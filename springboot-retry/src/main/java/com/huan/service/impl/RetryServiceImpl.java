package com.huan.service.impl;

import com.huan.service.RetryService;
import com.huan.util.DateUtils;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/9/19 - 17:43
 */
@Service
public class RetryServiceImpl implements RetryService {

    private static int i = 0;

    @Retryable(value = {MyException.class}, maxAttempts = 5, backoff = @Backoff(delay = 1000, multiplier = 1))
    public void restryTest() {
        i++;
        System.out.println((DateUtils.getSMSCurrTime()) + "------try " + i + " times...");
        //重试结束,还是失败,抛出异常
        throw new MyException();
    }

    /**
     * 重试结束执行方法
     */
    @Recover
    public void recover(NullPointerException e) {
        System.out.println("--------最终执行方法");
        System.out.println(e.getMessage());
        e.printStackTrace();
    }

    /**
     * 自定义异常类
     */
    class MyException extends RuntimeException {
        public MyException() {
            super("CRITICAL: even after retried attempt and delay, the method was excute error." +
                    "\n@See RetryServiceImpl#restryTest");
        }
    }


}
