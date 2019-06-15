package com.chenss.test;

import com.chenss.dao.ChenssDao;
import com.chenss.dao.ChenssDaoImpl;
import com.chenss.dao.UserDao;
import com.chenss.dao.UserDaoImpl;
import com.chenss.proxy.*;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        /*UserDao userDao= new UserDaoImpl();
        UserDao userDaoLog = new UserDaoLog(userDao);
        //UserDaoImpl userDao = new UserDaoLogTimer();
        userDaoLog.query();*/
        //自定义代理实现
        /*ChenssDao chenssDao = (ChenssDao) ProxyUtil.newInstance(new ChenssDaoImpl());
        System.out.println("chenssDao.query()   " +chenssDao.query());
        System.out.println("chenssDao.query(\"chenss002\")   " +chenssDao.query("chenss002"));;
        chenssDao.query("chenss002", 25);*/

        ChenssDao chenssDao = (ChenssDao) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{ChenssDao.class}, new ChenssInvocationHandler(new ChenssDaoImpl()));

        System.out.println("chenssDao.query()   " +chenssDao.query());
        System.out.println("chenssDao.query(\"chenss002\")   " +chenssDao.query("chenss002"));;
        chenssDao.query("chenss002", 25);
    }
}
