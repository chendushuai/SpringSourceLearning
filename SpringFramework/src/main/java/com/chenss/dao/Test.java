package com.chenss.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //IndexService indexService = (IndexService) classPathXmlApplicationContext.getBean("indexService");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);
        IndexService indexService = (IndexService) annotationConfigApplicationContext.getBean("indexService");
        indexService.service();
        IndexService indexService1 = (IndexService) annotationConfigApplicationContext.getBean("indexService");
        indexService1.service();
    }
}
