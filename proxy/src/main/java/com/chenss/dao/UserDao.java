package com.chenss.dao;

public interface UserDao {
    void query();
    void query(String name);
    void query(String name, int age);
}
