package com.chenss.algorithm;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author User
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0;
        int curr = 0;
        int right = 2;
        int maxRight = right;
        while (true) {
            if (curr >= height.length - 2) {
                break;
            }
            if (height[curr] <= height[curr + 1] || height[curr] == 0) {
                curr++;
                continue;
            }
            if (right < curr + 2) {
                maxRight = right = curr + 2;
            }
            if (height[right] >= height[curr]) {
                for (int i = curr + 1; i < right; i++) {
                    sum += height[curr] - height[i];
                }
                curr = right;
                maxRight = right = curr + 2;
            }
            if (maxRight >= height.length - 1) {
                if (right >= height.length - 1) {
                    right = height.length - 1;
                }
                for (int i = curr + 1; i < right; i++) {
                    if (height[i] >= height[right]) {
                        continue;
                    }
                    sum += height[right] - height[i];
                }
                curr = right;
                maxRight = right = curr + 2;
                continue;
            }
            if (height[maxRight] > height[right]) {
                right = maxRight;
            }
            maxRight++;
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{2, 1, 0, 2}));
        System.out.println(trappingRainWater.trap(new int[]{0, 2, 0}));
        System.out.println(trappingRainWater.trap(new int[]{2, 0, 2}));
        System.out.println(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
