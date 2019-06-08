package com.chenss.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class IndexDaoImpl1 implements IndexDao {
    public IndexDaoImpl1() {
        //System.out.println("IndexDaoImpl1 init");
    }

    @Override
    public void test() {
        System.out.println("IndexDaoImpl1");
    }
}
