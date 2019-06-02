package com.chenss.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao, InitializingBean {
    @Override
    public void test() {
        System.out.println("impl ");
    }
    public IndexDaoImpl() {
        System.out.println("Contructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialize");
    }
}
