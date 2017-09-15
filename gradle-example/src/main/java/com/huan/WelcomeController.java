package com.huan;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ptmind on 2016/5/21.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WelcomeController {

    @RequestMapping(value = "/")
    public Map<String, Object> welcome() {
        Map<String, Object> map = new HashMap();
        map.put("time", new Date());
        map.put("message", "Hello World");
        return map;
    }

}