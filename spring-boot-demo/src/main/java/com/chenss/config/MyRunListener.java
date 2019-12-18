package com.chenss.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyRunListener implements SpringApplicationRunListener {
    public MyRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("程序开始准备了");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("程序开始environmentPrepared了");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("程序开始contextPrepared了");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("程序开始contextLoaded了");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("程序开始started了");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("程序开始running了");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("程序开始failed了");
    }
}
