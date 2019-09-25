package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> colList = new ArrayList<>();
            if (i==0) {
                colList.add(1);
                result.add(colList);
                continue;
            }
            for (int j = 0; j < i + 1; j++) {
                if (j==0) {
                    colList.add(1);
                    continue;
                }
                if (j==i) {
                    colList.add(1);
                    break;
                }
                colList.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(colList);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle pa=new PascalsTriangle();
        System.out.println(pa.generate(5));
    }
}
