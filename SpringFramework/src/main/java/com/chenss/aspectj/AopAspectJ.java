package com.chenss.aspectj;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspectJ {
    @Pointcut("execution(* com.chenss.dao.*.*(..))")
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
