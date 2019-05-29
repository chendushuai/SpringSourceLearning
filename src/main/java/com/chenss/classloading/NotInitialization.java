package com.chenss.classloading;

/**
 * 被动使用类字段演示二
 * 通过数组定义来引用类，不会触发此类的初始化
 */
public class NotInitialization {
    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        SuperClass[] sca = new SuperClass[10];
        System.out.println(sca.getClass());
    }
}
