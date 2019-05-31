package com.chenss.classloading;

import java.util.ArrayList;
import java.util.List;

/**
 * 非主动使用类字段演示
 */
public class NotInitialization {
    public static void main(String[] args) {
        //System.out.println(ConstClass.HELLOWORLD);
        List<SuperClass> superClassList = new ArrayList<>();
        while(true) {
            superClassList.add(new SuperClass());
        }
    }
}
