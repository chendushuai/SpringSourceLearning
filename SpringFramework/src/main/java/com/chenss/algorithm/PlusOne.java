package com.chenss.algorithm;

import java.util.Arrays;

/**
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int add = 0;
        if (digits[digits.length - 1] == 9) {
            add = 1;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }
        int index = digits.length - 1;
        while (add == 1) {
            if (index == 0) {
                int[] newIndex = new int[digits.length + 1];
                newIndex[0] = 1;
                return newIndex;
            }
            digits[index] = 0;
            if (digits[index - 1] == 9) {
                add = 1;
                index--;
                continue;
            } else {
                digits[index - 1] = digits[index - 1] + 1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne pp = new PlusOne();
        //System.out.println(Arrays.toString(pp.plusOne(new int[]{0})));
        //System.out.println(Arrays.toString(pp.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(pp.plusOne(new int[]{8, 9, 9, 9})));
        System.out.println(Arrays.toString(pp.plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(pp.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(pp.plusOne(new int[]{4, 3, 2, 2})));
    }
}
