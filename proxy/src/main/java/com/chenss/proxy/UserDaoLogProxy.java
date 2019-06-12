package com.chenss.proxy;

import com.chenss.dao.UserDaoImpl;

public class UserDaoLogProxy extends UserDaoImpl {
    @Override
    public void query() {
        System.out.println("UserDaoLogProxy proxy");
        super.query();
    }
}
