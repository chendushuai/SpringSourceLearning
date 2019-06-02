package com.chenss.config;

import com.chenss.service.IndexService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.chenss")
@ImportResource("classpath:spring.xml")//三者混合使用，导入XML配置文件
public class Spring {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUrl("root");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return driverManagerDataSource;
    }
    @Bean
    @Autowired//Spring5之后可以不写
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        System.out.println("chenss002");
        return sqlSessionFactoryBean;
    }
}
