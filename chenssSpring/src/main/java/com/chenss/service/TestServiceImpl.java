package com.chenss.service;

import com.chenss.anno.AutoWiredChenss;
import com.chenss.anno.Chenss;
import com.chenss.dao.TestDao;
import com.chenss.dao.UserDao;

@Chenss("testService")
public class TestServiceImpl implements UserService {
    @Override
    public void find() {
        System.out.println("UserServiceImpl find");
    }
}
