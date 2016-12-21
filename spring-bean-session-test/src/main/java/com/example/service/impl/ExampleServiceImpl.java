package com.example.service.impl;

import com.example.service.ExampleService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Created by ptmind on 2016/12/21.
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class ExampleServiceImpl implements ExampleService {

    public void testSessionScope() {
        System.out.println("-------------");
    }

}
