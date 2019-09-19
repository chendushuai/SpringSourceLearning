package com.chenss.algorithm;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenss002
 */
public class JumpGameii {
    public int jump(int[] nums) {
        if (nums.length<=1) {
            return 0;
        }
        int jump = 0;
        int maxJumpLength = 0;
        int jumpLength = 0;
        int currIndex = 0;

        int maxLength=nums.length-1;
        while (jumpLength<maxLength) {
            jump++;
            if (jumpLength+nums[currIndex]>=maxLength) {
                jumpLength = maxLength;
                break;
            }
            for (int i = currIndex+1; i <= currIndex+nums[currIndex]; i++) {
                if (i+nums[i]>maxJumpLength) {
                    maxJumpLength=i+nums[i];
                    jumpLength=i;
                }
            }
            currIndex=jumpLength;
            if (maxJumpLength>=maxLength) {
                jump++;
                jumpLength = maxLength;
                break;
            } else {
                maxJumpLength=jumpLength;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGameii jumpGameii = new JumpGameii();
        System.out.println(jumpGameii.jump(new int[]{1,1,1,1}));
    }
}
