package com.chenss.algorithm;

import java.util.*;

/**
 * 39. 组合总和
 * 难度：中等
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenss002
 */
public class CombinationCum {
    public List<List<Integer>> result = new ArrayList<>();
    public int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> itemList = new ArrayList<>();
        if(target == 0 && candidates.length>0 &&candidates[0]==0) {
            itemList.add(0);
            result.add(itemList);
            return result;
        }
        this.candidates = candidates;
        for (int i = 0; i < this.candidates.length; i++) {
            itemList = new ArrayList<>();
            int currSum = this.candidates[i];
            if (currSum ==target) {
                itemList.add(this.candidates[i]);
                result.add(itemList);
            } else if (currSum > target) {
                break;
            } else {
                itemList.add(this.candidates[i]);
                sum(itemList,currSum,target);
            }
        }
        return result;
    }

    public void sum(List<Integer> intList, int current, int target) {
        for (int i = 0; i < this.candidates.length; i++) {
            int currSum = current + this.candidates[i];
            if (currSum ==target) {
                List<Integer> copyList = new ArrayList<>(intList);
                copyList.add(this.candidates[i]);
                Collections.sort(copyList);
                if (!result.contains(copyList)) {
                    result.add(copyList);
                }
            } else if (currSum > target) {
                break;
            } else {
                List<Integer> copyList = new ArrayList<>(intList);
                copyList.add(this.candidates[i]);
                sum(copyList,currSum,target);
            }
        }
    }

    public static void main(String[] args) {
        CombinationCum combinationCum = new CombinationCum();
        System.out.println(combinationCum.combinationSum(new int[]{2,3,6,7},7));
        System.out.println();
        combinationCum.result = new ArrayList<>();
        System.out.println(combinationCum.combinationSum(new int[]{2,3,5},8));
    }
}
