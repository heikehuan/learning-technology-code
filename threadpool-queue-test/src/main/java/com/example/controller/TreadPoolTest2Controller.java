package com.example.controller;

import com.example.bean.UserBean;
import com.example.service.BusinessService;
import com.example.workThread.WorkTread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhanhuanhuan on 2016/12/21.
 */
@Controller
public class TreadPoolTest2Controller {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/test2")
    @ResponseBody
    public Object test(String id, String name, String age) {
        System.out.println("----------------method start");
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setName(name);
        userBean.setAge(age);
        //工作线程
        WorkTread workTread = new WorkTread(businessService, userBean);
        threadPoolTaskExecutor.execute(workTread);
        System.out.println("---------------method end");
        return "ok";
    }


}
