package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * @author chenss002
 */
public class LettetCombinationsOfAFhoneNumber {
    public String[] button = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> resu = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        combine(digits,"");
        return resu;
    }
    
    public void combine(String digits,String now) {
        if (now.length() == digits.length()) {
            return ;
        }
        String sButt = button[Integer.parseInt(digits.charAt(now.length()) +"")];
        for (int i = 0; i < sButt.length(); i++) {
            String curr = now+sButt.charAt(i);
            if (curr.length() == digits.length() && !resu.contains(curr)) {
                resu.add(curr);
            } else {
                combine(digits,curr);
            }
        }
        return;
    }
    public static void main(String[] args) {
        LettetCombinationsOfAFhoneNumber com =new LettetCombinationsOfAFhoneNumber();
        System.out.println(com.letterCombinations("").toString());
        com.resu = new ArrayList<>();
        System.out.println(com.letterCombinations("23").toString());
        com.resu = new ArrayList<>();
        System.out.println(com.letterCombinations("235").toString());
        com.resu = new ArrayList<>();
        System.out.println(com.letterCombinations("22").toString());
        com.resu = new ArrayList<>();
        System.out.println(com.letterCombinations("232").toString());
    }
}
