package com.huan.service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/9/19 - 17:42
 */
public interface RetryService {

    void restryTest();

    void recover(NullPointerException e);
}
