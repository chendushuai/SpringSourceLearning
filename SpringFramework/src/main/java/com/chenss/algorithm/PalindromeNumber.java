package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 * @date 2019-9-26 09:39:41
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        List<Integer> intList=new ArrayList<>();
        if (x<0) {
            return false;
        }
        if (x<10) {
            return true;
        }
        String xStr = Integer.toString(x);
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i)!=xStr.charAt(xStr.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(101));
        System.out.println(palindromeNumber.isPalindrome(10));
        System.out.println(palindromeNumber.isPalindrome(-121));
    }
}
