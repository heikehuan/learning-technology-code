package com.example.workThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by ptmind on 2016/12/21.
 */
//线程池中工作的线程
@Component("dBThread")
@Scope("prototype")//spring 多例
public class DBThread implements Runnable {
    private String msg;
    private Logger log = LoggerFactory.getLogger(DBThread.class);

    public void run() {
        insert(new Date(1469704224159L), msg);
        log.info("insert->" + msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private int insert(Date date, String msg) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert  into `system_log`(`time`,`log_describe`) values (?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setDate(1, date);
            pstmt.setString(2, msg);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}