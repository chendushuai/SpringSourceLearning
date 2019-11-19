package com.chenss.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * 通过自主定义类，实现接口ServletContainerInitializer
 * 添加META-INF/services/javax.servlet.ServletContainerInitializer文件
 * 内嵌tomcat启动时，文件放置在resources目录，否则放置在webapp目录下
 * 修改文件内容为实现类com.chenss.initializer.MyServletContainerInitializer
 * 即可实现在tomcat启动时即调用该类
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("启动了");
    }
}
