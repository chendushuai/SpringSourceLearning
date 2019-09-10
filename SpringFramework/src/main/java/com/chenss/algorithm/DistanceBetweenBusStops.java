package com.chenss.algorithm;

import java.util.Arrays;

/**
 * 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *  
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 *  
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 处理方式为两个方向都进行距离合计，然后计算两边长度的比较，得到最短长度
 * @author chenss002
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int minDis = 0;
        int maxLen = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i>=start && i<destination) {
                maxLen += distance[i];
            } else {
                minDis += distance[i];
            }
        }
        return maxLen > minDis ? minDis : maxLen;
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops dis = new DistanceBetweenBusStops();
        System.out.println(dis.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(dis.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(dis.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }
}
