package com.chenss.proxy;

import com.chenss.dao.UserDao;

public class UserDaoLog implements UserDao {
    private UserDao userDao;
    public UserDaoLog(UserDao userDao) {
        this.userDao=userDao;
    }
    @Override
    public void query() {
        System.out.println("UserDaoLog log");
        userDao.query();
    }
}
