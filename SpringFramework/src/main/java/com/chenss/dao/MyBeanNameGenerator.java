package com.chenss.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class MyBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        System.out.println(beanDefinition.getBeanClassName());
        return beanDefinition.getBeanClassName();
    }
}
