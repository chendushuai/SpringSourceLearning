package com.chenss.algorithm;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxSum = 0;
        if (height.length<=2) {
            return 0;
        }
        int curr=0;
        int right=0;
        int maxRight = 0;
        int maxHeight = 0;

        while (true) {
            // 如果当前判断的位置已经移动到倒数第二位之后，则可以直接结束
            if (curr>=height.length-2) {
                break;
            }
            // 如果当前位置为0，或当前位置的值小于等于下一个位置的值，则直接移动到下一个位置
            if (height[curr]==0 || height[curr]<=height[curr+1]) {
                curr=curr+1;
                maxHeight=0;
                continue;
            }
            // 如果下一个位置的值是最高点，则记录
            if (height[curr+1]>maxHeight) {
                maxHeight=height[curr+1];
                right=curr+1;
            }
            // 如果最大坐标小于当前值的后一位，则移动到当前值后一位
            if (maxRight<curr+1) {
                maxRight = curr+1;
            }
            // 如果最大坐标等于最后一位，则直接结算，然后进行下一次循环
            if (maxRight==height.length-1) {
                for (int i = curr+1; i < right; i++) {
                    maxSum+=height[right]-height[i];
                }
                curr=right;
                maxHeight=0;
                maxRight=curr+1;
                right=curr+1;
                continue;
            }
            // 如果找到最大值
            if (height[maxRight+1]>maxHeight) {
                // 如果最大值比当前位置的值还要大，直接计算，然后移位
                if (height[maxRight+1]>height[curr]) {
                    for (int i = curr+1; i < maxRight+1; i++) {
                        maxSum+=height[curr]-height[i];
                    }
                    curr=maxRight+1;
                    maxHeight=0;
                    continue;
                }

                // 否则记录最大值和位置
                maxHeight=height[maxRight+1];
                right = maxRight+1;
                maxRight++;
                continue;
            }
            maxRight++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
        //System.out.println(water.trap(new int[]{2,0,2}));
        //System.out.println(water.trap(new int[]{0,2,0}));
        System.out.println(water.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
