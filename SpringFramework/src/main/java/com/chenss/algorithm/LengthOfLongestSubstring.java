package com.chenss.algorithm;

import jdk.nashorn.internal.ir.Flags;

import java.util.HashMap;
import java.util.Map;

/**
 * @author User
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring len = new LengthOfLongestSubstring();
        System.out.println(len.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        //移动到的位置
        int i = 0;
        //标注点起始位置
        int tag =0;
        // 已有字符的长度
        int length = 0;
        while (i<s.length()) {
            // 从标注点开始查找指定字符
            int position = s.indexOf(s.charAt(i), tag);
            // 如果查询的字符在移动到的点之前，则证明之前的字符串存在重复
            if (position<i) {
                // 如果位置在i之前，且已有长度大于最大长度，则保存最新长度
                if (length>maxLength) {
                    maxLength=length;
                }
                //如果最大长度已经大于等于剩余的字符串长度，则直接跳出
                if (maxLength>=s.length()-position-1) {
                    return maxLength;
                }
                // 得到最新的剩余可计算的字符串长度，该长度为重复点之后一位到当前移动点。
                length=i-position-1;
                // 重置标签点为的重复点之后一位
                tag = position+1;
            }
            i++;
            length ++;
        }
        return length;
        /*if (null == s || s.length()==0) {
            return 0;
        }
        int maxLenth = 1;
        Map<Character,Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                int temp =charMap.get(s.charAt(i));
                maxLenth = maxLenth<charMap.keySet().size() ? charMap.keySet().size():maxLenth;
                i=temp;
                charMap.clear();
                continue;
            }
            charMap.put(s.charAt(i),i);
        }
        maxLenth = maxLenth<charMap.keySet().size() ? charMap.keySet().size():maxLenth;
        return maxLenth;*/
    }
}
