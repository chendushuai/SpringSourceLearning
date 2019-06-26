package com.chenss.test;

import com.chenss.config.Spring;
import com.chenss.dao.ChenssFactoryBean;
import com.chenss.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestFactoryBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);
        ChenssFactoryBean chenssFactoryBean = (ChenssFactoryBean) annotationConfigApplicationContext.getBean("&chenssFactoryBean");
        chenssFactoryBean.testBean();
        IndexDaoImpl indexDaoImpl = (IndexDaoImpl) annotationConfigApplicationContext.getBean("chenssFactoryBean");
        indexDaoImpl.test();
    }
}
