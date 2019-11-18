package com.chenss.concurr;

import java.util.concurrent.ConcurrentHashMap;

public class TestCurr {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("111","1112");
        System.out.println(concurrentHashMap.contains("111"));
        System.out.println(concurrentHashMap.containsKey("111"));
        System.out.println(concurrentHashMap.containsValue("1112"));
        System.out.println(concurrentHashMap.size());
        System.out.println(concurrentHashMap.keySet());
        System.out.println(concurrentHashMap.elements());
        System.out.println(concurrentHashMap.get("111"));
    }
}
