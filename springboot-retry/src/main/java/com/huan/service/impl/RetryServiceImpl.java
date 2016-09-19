package com.huan.service.impl;

import com.huan.service.RetryService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/9/19 - 17:43
 */
@Service
public class RetryServiceImpl implements RetryService {

    public void restryTest() {
        System.out.println("do something...");
        throw new NullPointerException("空指针异常");
    }

    public void recover(NullPointerException e) {
        System.out.println("--------最终执行方法");
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
