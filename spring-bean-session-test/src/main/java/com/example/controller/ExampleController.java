package com.example.controller;

import com.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ptmind on 2016/12/21.
 */
@Controller
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("test")
    public String test(ModelMap modelMap) {
        System.out.println(exampleService.hashCode() + "---");
        exampleService.testSessionScope();
        return "success";
    }
}
