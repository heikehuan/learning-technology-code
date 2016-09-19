package com.huan.controller;

import com.huan.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ptmind on 2016/5/16.
 */
@Controller
public class Demo {

    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String restryTest() {
        retryService.restryTest();
        return "success";
    }

}
