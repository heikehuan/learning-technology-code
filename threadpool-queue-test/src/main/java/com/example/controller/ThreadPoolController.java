package com.example.controller;

import com.example.config.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ptmind on 2016/12/21.
 */
@Controller
public class ThreadPoolController {

    @Autowired
    ThreadPoolManager threadPoolManager;

    @RequestMapping("/pool")
    @ResponseBody
    public Object test() {
        for (int i = 0; i < 70; i++) {
            //模拟并发500条记录
            threadPoolManager.processOrders(Integer.toString(i));
        }
        return "ok";
    }


}