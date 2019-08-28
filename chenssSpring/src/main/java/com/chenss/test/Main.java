package com.chenss.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N表示物品数量
        int n = scanner.nextInt();
        // V表示物品数量最大量
        int v = scanner.nextInt();
        // 存储第i个物品数量
        int[] nArr = new int[n];
        // 存储第n个物品价值
        int[] vArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
            vArr[i] = scanner.nextInt();
        }
        scanner.close();

        int maxValue = 0;// 找到最大值，循环以每个值作为初始值来计算
        for (int i = 0; i < n; i++) {
            int beginIndex = i + 1;
            int recursiveMax = RecursiveArray(nArr, vArr, n, v, beginIndex);
            if (recursiveMax > maxValue) {
                maxValue = recursiveMax;
            }
        }
        System.out.println(maxValue);
    }

    /**
     * 递归计算判断
     *
     * @param nArr 货物数量数组
     * @param vArr 货物价值数组
     * @param maxN 货物数量
     * @param maxV 最多可承载货物数量
     * @param beginI  开始的序号
     * @return 返回计算出的最大价值
     */
    public static int RecursiveArray(int[] nArr, int[] vArr, int maxN, int maxV,int beginI) {
        int[][] max = new int[maxV+1][maxN-beginI+1];
        for (int i = 0; i <= maxN-beginI+1; i++) {
            max[0][i] =0;
        }
        for (int i = 0; i <= maxV; i++) {
            for (int j = 0; j < maxN-beginI+1; j++) {

            }
        }
        return max[maxV][maxN-beginI];
    }
}
