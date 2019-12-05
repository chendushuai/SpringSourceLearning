package com.chenss.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过使用@Configuration和@Bean方式也可以实现端口修改
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(8091);
        return tomcatServletWebServerFactory;
    }
}
