package com.chenss.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1","1");

        int i = "chenss002".hashCode();
        System.out.println("hash: " + Integer.toBinaryString(i));
        System.out.println("15  : " + Integer.toBinaryString(15));
        int andV = 15 & i;
        int yiV = 15 ^ i;
        System.out.println("&   ：" + andV + " bin : " + Integer.toBinaryString(andV));
        System.out.println("^   ：" + yiV + " bin : " + Integer.toBinaryString(yiV));
        int yiwei = i >> 16;
        int yiwei2 = i >>> 16;
        System.out.println(">>  ：" + yiwei + " bin : " + Integer.toBinaryString(yiwei));
        System.out.println(">>> ：" + yiwei2 + " bin : " + Integer.toBinaryString(yiwei2));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("12","23");
    }
}
