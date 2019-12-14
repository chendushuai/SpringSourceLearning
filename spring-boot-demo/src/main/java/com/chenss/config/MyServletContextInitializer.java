package com.chenss.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 使用内嵌的Web容器，必须提供ServletContextInitializer接口的实现类，才能在初始化的时候执行
 */
@Component
public class MyServletContextInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("MyServletContextInitializer run");
    }
}
