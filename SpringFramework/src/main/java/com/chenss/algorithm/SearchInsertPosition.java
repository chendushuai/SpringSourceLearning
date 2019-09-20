package com.chenss.algorithm;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenss002
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int insertIndex = 1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2;
            if (nums[left + mid] < target) {
                insertIndex = left + mid + 1;
                left = left + mid;
            } else {
                insertIndex = left + mid;
                right = right - mid;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5},4));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1},1));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6},0));
    }
}
