package com.chenss.proxy;

import java.lang.reflect.Method;

public interface CustomInvocationHandler {
    public Object invoke(Method method,Object[] args);
}
