package com.huan.controller;

import com.huan.model.TUser;
import com.huan.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ptmind on 2016/7/15.
 */
@RestController
public class TestController {

    @Autowired
    private MainPageService mainPageService;

    @RequestMapping("test")
    public List<TUser> selectAll() {
        return mainPageService.selectAll();
    }
}
