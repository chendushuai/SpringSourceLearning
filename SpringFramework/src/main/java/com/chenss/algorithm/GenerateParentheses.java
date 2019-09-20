package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 难度中等
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        addGe("",0,0,n);
        return result;
    }
    public void addGe(String curr,int left,int right,int n) {
        if (curr.length() == n*2){
            result.add(curr);
            return;
        }
        if(left<n) {
            addGe(curr+"(",left+1,right,n);
        }
        if(right<left) {
            addGe(curr+")",left,right+1,n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
