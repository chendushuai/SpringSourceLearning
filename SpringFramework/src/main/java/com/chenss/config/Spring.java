package com.chenss.config;

import com.chenss.service.IndexService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

@Configuration
//使用下面一行的形式在扫描Bean时排除掉指定包中的类，或使用excludeFilters = @ComponentScan.Filter(Service.class)排除掉指定注解类型的类
@ComponentScan(value = "com.chenss", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.chenss.service.*"))
//@ComponentScan(value = "com.chenss", excludeFilters = @ComponentScan.Filter(Service.class))
@ImportResource("classpath:spring.xml")//三者混合使用，导入XML配置文件
public class Spring {
}
