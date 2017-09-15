package com.huan.service.impl;

import com.huan.service.AsyncTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptmind.com">詹欢欢</a>
 * @since 2017/7/25 - 19:09
 */
@Service
public class AsyncTestServiceImpl implements AsyncTestService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public void async() {
        logger.debug("-------the async thread --------");
    }
}
