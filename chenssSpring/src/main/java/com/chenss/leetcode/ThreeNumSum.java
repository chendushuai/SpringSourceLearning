package com.chenss.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 解题思路：
         *
         * 1. 首先规定一个值，也就是选定一个基准值，这里选择从第一个元素顺序判断下去
         * 2. 剩余的元素首尾同时以游标方式缩减计算
         *
         */
        List<List<Integer>> listResult = new ArrayList<>();
        // 先对数据进行排序，获取有顺序的数组
        Arrays.sort(nums);

        // 获取数组元素个数，避免重复计算
        int len = nums.length;
        // 循环数组，取值进行计算
        for (int i = 0; i < len; i++) {
            // 如果选定的基准值，同之前选定的基准值相同，则直接略过，因为会产生同样的结果
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 设置剩余值左侧游标
            int left = i + 1;
            // 设置剩余值右侧游标
            int right = len - 1;

            // 判断只有当游标位置形成区间的时候才进行判断
            while (left < right) {
                // 判断基准值同游标对应值的累计和
                int tmp = nums[i] + nums[left] + nums[right];
                // 如果累计和为0，则认为满足计算和为0的条件
                if (tmp == 0) {
                    // 将满足条件的数值放入结果集中
                    listResult.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果满足游标区间的同时，连续多个相同，则直接忽略
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 此处两个游标同时向内移动，因为在基准值固定的情况下，一个游标值只能同另一个固定值组合为0
                    left++;
                    right--;
                } else if (tmp > 0) {
                    // 如果累计结果大于0，说明右侧值过大，需要右侧游标左移
                    while (nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    // 如果累计结果小于0，说明左侧值过小，需要左侧游标右移
                    while (nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return listResult;
    }

    public static void main(String[] args) {
        ThreeNumSum sum = new ThreeNumSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = sum.threeSum(nums);
        System.out.println(list.toString());
    }
}
