package com.huan.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptmind.com">詹欢欢</a>
 * @since 2017/7/27 - 19:05
 */
@Service
public class NoInterfaceTestService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public void async() {
        logger.debug("-------the async thread --------");
    }
}
