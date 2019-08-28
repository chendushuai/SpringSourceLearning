package com.chenss.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hasMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if (hasMap.containsKey(target-nums[i])) {
                return new int[]{hasMap.get(target-nums[i]),i};
            }
            hasMap.put(nums[i],i);
        }
        return null;
    }
}
