package com.chenss.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> strIng = new LinkedHashSet<>();
        System.out.println(strIng.add("trres"));
        System.out.println(strIng.add("sssss"));
        System.out.println(strIng.add("sssss"));
    }
}
