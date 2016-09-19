package com.huan.controller;

import com.huan.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ptmind on 2016/5/20.
 */
@RestController
public class RestDemo {

    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "/restryTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String restryTest() {
        retryService.restryTest();
        return "success";
    }



}
