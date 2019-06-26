package com.chenss.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("chenssFactoryBean")
public class ChenssFactoryBean implements FactoryBean {
    public void testBean(){
        System.out.println("ChenssFactoryBean");
    }
    @Override
    public Object getObject() throws Exception {
        return new IndexDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return IndexDaoImpl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
