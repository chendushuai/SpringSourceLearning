package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 */
public class FindRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        if (nums.length<=1) {
            return -1;
        }
        if (nums.length==2&&nums[0]!=nums[1]) {
            return -1;
        }
        BitSet bitSet = new BitSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (bitSet.get(nums[i])) {
                return nums[i];
            }
            bitSet.set(nums[i],true);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
