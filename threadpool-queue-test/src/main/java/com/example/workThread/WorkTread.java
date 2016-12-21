package com.example.workThread;

import com.example.bean.UserBean;
import com.example.service.BusinessService;

/**
 * Created by ptmind on 2016/12/21.
 */
public class WorkTread implements Runnable {

    private BusinessService businessService;
    private UserBean userBean;

    public WorkTread(BusinessService businessService, UserBean userBean) {
        this.businessService = businessService;
        this.userBean = userBean;
    }

    /**
     * 执行多线程
     */
    public void run() {
        //业务处理
        businessService.test(userBean);
    }
}
