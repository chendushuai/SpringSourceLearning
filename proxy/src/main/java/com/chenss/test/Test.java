package com.chenss.test;

import com.chenss.proxy.UserDaoLogImpl;

public class Test {
    public static void main(String[] args) {
        UserDaoLogImpl userDao = new UserDaoLogImpl();
        userDao.query();
    }
}
