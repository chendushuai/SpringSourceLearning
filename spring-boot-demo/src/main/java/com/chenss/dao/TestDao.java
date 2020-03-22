package com.chenss.dao;

public class TestDao {
    public TestDao(){
        System.out.println("TestDao Init");
    }

    public void test() {
        System.out.println("3");
        System.out.println(this.getClass().getClassLoader());
    }
}
