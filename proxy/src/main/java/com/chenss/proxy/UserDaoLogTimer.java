package com.chenss.proxy;

import com.chenss.dao.UserDaoImpl;

public class UserDaoLogTimer extends UserDaoImpl {
    @Override
    public void query() {
        System.out.println("UserDaoLogTimer proxy");
        super.query();
    }
}
