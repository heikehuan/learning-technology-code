package com.huan.controller;

import com.huan.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/6/23 - 11:41
 */
@RestController
@RequestMapping("/")
public class Hello {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User view() {
        User user = new User();
        user.setId(123L);
        user.setName("zhang");
        return user;
    }

}
