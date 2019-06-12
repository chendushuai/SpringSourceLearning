package com.chenss.proxy;

import com.chenss.dao.UserDaoImpl;

public class UserDaoLogImpl extends UserDaoImpl {
    @Override
    public void query() {
        System.out.println("UserDaoLogImpl proxy");
        super.query();
    }
}
