package com.chenss.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCustomInvocationHandler implements CustomInvocationHandler {
    private Object target;
    public TestCustomInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Method target, Object... args) {
        try {
            System.out.println();
            System.out.println("TestCustomInvocationHandler proxy");
            return target.invoke(this.target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
