package com.huan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/6/23 - 11:41
 */
@RestController
@RequestMapping("/")
public class Hello {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map view() {
        Map map = new HashMap<>();
        map.put("id", 123);
        map.put("name", "huan");
        return map;
    }

}
