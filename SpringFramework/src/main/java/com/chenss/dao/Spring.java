package com.chenss.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.chenss")
@ImportResource("classpath:spring.xml")//三者混合使用，导入XML配置文件
public class Spring {
}
