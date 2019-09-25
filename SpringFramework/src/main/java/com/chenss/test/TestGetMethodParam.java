package com.chenss.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author User
 * @date 2019-9-24 23:35:59
 */
public class TestGetMethodParam {
    public void test(String name,int ages) {

    }

    public static void main(String[] args) {
        Method method = null;
        try {
            method = Class.forName(TestGetMethodParam.class.getName()).getMethod("test",String.class,int.class);
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.println(parameters[i].getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
