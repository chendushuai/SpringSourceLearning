package com.chenss.test;

import com.chenss.dao.UserDao;
import com.chenss.dao.UserDaoImpl;
import com.chenss.proxy.UserDaoLog;
import com.chenss.proxy.UserDaoLogImpl;
import com.chenss.proxy.UserDaoLogProxy;
import com.chenss.proxy.UserDaoLogTimer;

public class Test {
    public static void main(String[] args) {
        UserDao userDao= new UserDaoImpl();
        UserDao userDaoLog = new UserDaoLog(userDao);
        //UserDaoImpl userDao = new UserDaoLogTimer();
        userDaoLog.query();
    }
}
