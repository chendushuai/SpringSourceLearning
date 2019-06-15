package com.chenss.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ChenssInvocationHandler implements InvocationHandler {
    private Object target;
    public ChenssInvocationHandler(Object target) {
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ChenssInvocationHandler jdk proxy");
        return method.invoke(target, args);
    }
}
