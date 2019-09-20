package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn. com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows==1 || numRows>= s.length()) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        //设置每个Z区大小为行数的两倍减2
        int maxZ = numRows*2-2;
        for (int i = 0; i < numRows; i++) {
            int mi = i;
            int mz=maxZ-i;
            // 循环递增进行组合
            // 此处设置第一整列到第二整列之前为一组，整列为一方向，斜线为一方向
            // 整列+斜线长度为行数*2-2;
            // 按组递增查找每个位置的值，组装成字符串
            while (mi<s.length()){
                result.append(s.charAt(mi));
                if (i>0 && i<s.length()-1 &&mz<s.length() && mi<mz) {
                    result.append(s.charAt(mz));
                }
                mi=mi+maxZ;
                mz=mz+maxZ;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("LEETCODEISHIRING",4));

    }
}
