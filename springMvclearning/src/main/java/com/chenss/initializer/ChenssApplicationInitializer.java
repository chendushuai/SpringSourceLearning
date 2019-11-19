package com.chenss.initializer;

import com.chenss.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ChenssApplicationInitializer implements WebApplicationInitializer {
    /**
     * 实现零XML，需要先写一个类，实现Spring的WebApplicationInitializer接口
     *
     * tomcat在启动时会调用onStartup方法
     *
     * onStartup方法中的参数ServletContext，也就是Web上下文对象
     *
     * 因为Servlet3.0 的一个新规范 而通过Servlet定义规范实现不同入口的兼容
     * @param servletContext
     * @throws ServletException
     */


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        //ac.refresh();
        // 这两行完成了对于Spring的初始化


        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");

        // registration.setInitParameter("","");// 指定初始化参数配置
    }
}
