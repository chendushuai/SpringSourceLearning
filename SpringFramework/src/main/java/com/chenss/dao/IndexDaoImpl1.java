package com.chenss.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl1 implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl0 ");
    }
}
