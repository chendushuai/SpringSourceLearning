package com.chenss.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoTest {
    public void test(String name,int age) {
        System.out.println(name + " - " + age);
    }
}
