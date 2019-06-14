package com.chenss.test;

import com.chenss.dao.UserDao;
import com.chenss.dao.UserDaoImpl;
import com.chenss.proxy.*;

public class Test {
    public static void main(String[] args) {
        /*UserDao userDao= new UserDaoImpl();
        UserDao userDaoLog = new UserDaoLog(userDao);
        //UserDaoImpl userDao = new UserDaoLogTimer();
        userDaoLog.query();*/
        UserDao userDao = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
        userDao.query();
    }
}
