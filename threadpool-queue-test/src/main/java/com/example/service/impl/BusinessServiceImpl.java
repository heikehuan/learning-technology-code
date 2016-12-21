package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.bean.UserBean;
import com.example.service.BusinessService;
import org.springframework.stereotype.Service;

/**
 * Created by ptmind on 2016/12/21.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    public void test(UserBean userBean) {
        System.out.println(JSON.toJSON(userBean));
    }
}
