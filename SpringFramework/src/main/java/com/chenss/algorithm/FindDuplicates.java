package com.chenss.algorithm;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            num=num<0?-num:num;
            if (nums[num-1]<0) {
                result.add(num);
            } else {
                nums[num-1]=-nums[num-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(findDuplicates(new int[]{4,3,2,7,8,2,3,1})));
    }
}
