package com.huan.controller;

import com.huan.service.AsyncTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:huanhuan.zhan@ptmind.com">詹欢欢</a>
 * @since 2017/7/25 - 19:02
 */
@RestController
public class AsyncController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTestService asyncTestService;

    @GetMapping("async")
    public String async() {
        logger.debug("---------the main thread");
        asyncTestService.async();
        return "success";
    }
}
