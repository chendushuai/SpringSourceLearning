package com.chenss.dao;

public interface ChenssDao {
    String query();
    int query(String name);
    void query(String name, int age);
}
