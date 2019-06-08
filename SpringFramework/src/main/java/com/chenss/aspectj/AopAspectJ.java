package com.chenss.aspectj;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspectJ {
    //@Pointcut("execution(* com.chenss.dao.*.*(..))")//匹配com.chenss.dao包下的所有接口和类的所有方法
    @Pointcut("execution(public String com.chenss.dao.*.*(..))")
    public void pointCut() {

    }
    @Before("pointCut()")
    public void before() {
        System.out.println("aspectJ before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("aspectJ after");
    }
    /*@Around("pointCut()")
    public void around() {
        System.out.println("aspectJ around");
    }*/
}
