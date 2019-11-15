package com.chenss.algorithm;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 * @date 2019-9-29 16:35:17
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return  "";
        }
        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char itemChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != itemChar) {
                    return sb.toString();
                }
            }
            sb.append(itemChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longest = new LongestCommonPrefix();
        System.out.println(longest.longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }));
        System.out.println(longest.longestCommonPrefix(new String[]{
                "dog","racecar","car"
        }));
        System.out.println(longest.longestCommonPrefix(new String[]{
                "c","c"
        }));
        System.out.println(longest.longestCommonPrefix(new String[]{
                "dog"
        }));
    }
}
