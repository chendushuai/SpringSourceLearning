package com.chenss.service;

import com.chenss.dao.TestDao;
import com.chenss.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private TestDao testDao;

    public UserServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    public UserServiceImpl(UserDao userDao, TestDao testDao) {
        this.userDao = userDao;
        this.testDao = testDao;
    }

    @Override
    public void find() {
        System.out.println("UserServiceImpl find");
        testDao.query();
        userDao.query();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
