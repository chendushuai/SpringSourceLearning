package com.chenss.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring len = new LengthOfLongestSubstring();
        System.out.println(len.lengthOfLongestSubstring("au"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length()==0) {
            return 0;
        }
        char[] arrChar = s.toCharArray();
        int maxLenth = 1;
        Map<Character,Integer> charMap = new HashMap<>();
        for (int i = 0; i < arrChar.length; i++) {
            if (charMap.containsKey(arrChar[i])) {
                int temp =charMap.get(arrChar[i]);
                maxLenth = maxLenth<charMap.keySet().size() ? charMap.keySet().size():maxLenth;
                i=temp;
                charMap.clear();
                continue;
            }
            charMap.put(arrChar[i],i);
        }
        maxLenth = maxLenth<charMap.keySet().size() ? charMap.keySet().size():maxLenth;
        return maxLenth;
    }
}
