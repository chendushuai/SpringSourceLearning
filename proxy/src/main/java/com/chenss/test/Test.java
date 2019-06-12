package com.chenss.test;

import com.chenss.dao.UserDaoImpl;
import com.chenss.proxy.UserDaoLogImpl;
import com.chenss.proxy.UserDaoLogProxy;
import com.chenss.proxy.UserDaoLogTimer;

public class Test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoLogTimer();
        userDao.query();
    }
}
