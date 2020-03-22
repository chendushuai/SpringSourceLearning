package com.chenss.algorithm;

import com.google.gson.Gson;

import java.sql.Statement;
import java.util.Arrays;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0] = newInterval;
            return intervals;
        }
        if (newInterval.length != 2) {
            return intervals;
        }
        int last = 0;
        int[][] newResult = new int[intervals.length + 1][2];
        boolean isMerge = false;
        if (newInterval[0] <= intervals[0][0]) {
            newResult[0] = newInterval;
            isMerge = true;
        } else {
            newResult[0] = intervals[0];
        }
        for (int i = isMerge ? 0 : 1; i < intervals.length; i++) {
            int[] nex = intervals[i];
            if (!isMerge) {
                if (newInterval[0] <= nex[0]) {
                    isMerge = true;
                    last = merge(newResult,newInterval,last);
                }
            }
            last = merge(newResult,nex,last);
        }
        if (!isMerge) {
            last = merge(newResult,newInterval,last);
        }
        return Arrays.copyOf(newResult, last + 1);
    }

    public static int merge(int[][] newResult,int[] m,int last) {
        if (m[0] <= newResult[last][1]) {
            newResult[last][1] = Math.max(newResult[last][1], m[1]);
        } else {
            newResult[++last] = m;
        }
        return last;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})));
        System.out.println(gson.toJson(insert(new int[][]{{1,3},{7,9}},new int[]{4,6})));
        System.out.println(gson.toJson(insert(new int[][]{{1,3},{7,9}},new int[]{3,8})));
        System.out.println(gson.toJson(insert(new int[][]{{1,5}},new int[]{2,7})));
    }
}
