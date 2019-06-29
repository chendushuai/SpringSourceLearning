package com.chenss.test;

import com.chenss.service.UserService;
import com.chenss.service.UserServiceImpl;
import org.spring.util.AnnotationConfigApplicationContext;
import org.spring.util.BeanFactory;

public class Test {
    public static void main(String[] args) {
        /*UserService userService = new UserServiceImpl();
        userService.find();*/
        /*BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService userService = (UserService) beanFactory.getBean("service");
        userService.find();*/
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.chenss");
    }
}
