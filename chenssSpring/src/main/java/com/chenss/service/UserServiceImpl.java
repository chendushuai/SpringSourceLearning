package com.chenss.service;

import com.chenss.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void find() {
        System.out.println("UserServiceImpl find");
        userDao.query();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
