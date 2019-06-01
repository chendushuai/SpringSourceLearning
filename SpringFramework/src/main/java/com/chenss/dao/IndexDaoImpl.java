package com.chenss.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl ");
    }
}
