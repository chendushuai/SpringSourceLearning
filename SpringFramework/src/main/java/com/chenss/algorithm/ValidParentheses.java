package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        List<Character> ll = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character cc;
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    ll.add(s.charAt(i));
                    break;
                case ')':
                    cc='(';
                    if (ll.size() == 0 || !cc.equals(ll.get(ll.size() - 1))) {
                        return false;
                    }
                    ll.remove(ll.size() - 1);
                    break;
                case '}':
                    cc='{';
                    if (ll.size() == 0 || !cc.equals(ll.get(ll.size() - 1))) {
                        return false;
                    }
                    ll.remove(ll.size() - 1);
                    break;
                case ']':
                    cc='[';
                    if (ll.size() == 0 || !cc.equals(ll.get(ll.size() - 1))) {
                        return false;
                    }
                    ll.remove(ll.size() - 1);
                    break;
                default:
                    break;
            }
        }
        if (ll.size()==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid(""));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
    }
}
