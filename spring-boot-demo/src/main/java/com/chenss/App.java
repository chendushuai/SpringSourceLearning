package com.chenss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * 使用exclude 来排除加载指定类
 * @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
 *
 * Sping 注入类的条件判断注解
 * @ConditionalOnXXX
 *
 * 判断当前项目里面有没有某个Class，如果有，就注入当前Bean
 * @ConditionalOnClass
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
