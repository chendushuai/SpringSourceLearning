package com.chenss.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl ");
    }
    public IndexDaoImpl() {
        System.out.println("Contructor");
    }
    public void init() {
        System.out.println("init");
    }
}
