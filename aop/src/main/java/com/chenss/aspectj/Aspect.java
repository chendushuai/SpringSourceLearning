package com.chenss.aspectj;

/**
 * AspectJ切面逻辑方法
 * 类中定义切面后需要执行的方法逻辑，用于在XML中绑定
 */
public class Aspect {
    public void before() {
        System.out.println("AspectJ before");
    }
    public void beforeName() {
        System.out.println("AspectJ name");
    }
}
