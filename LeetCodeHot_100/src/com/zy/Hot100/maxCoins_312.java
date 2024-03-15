package com.zy.Hot100;

import java.util.*;

/*
312. 戳气球[递归、动态规划、分治]
有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
求所能获得硬币的最大数量。
分析：每戳破一个气球，元素位置移动，不利于操作。反向处理，改为在第i个位置插入气球。
对于n个气球，则在(0,n+1)的区间中，枚举mid的位置，每插入一个气球得到的硬币为：val(left)*val(mid)*val(right)，同时枚举在(left, mid)和(mid, right)插入气球所获最大硬币数量
则最终所获最大硬币数量可表示为solve(0,n+1) = max{val(left)*val(mid)*val(right)}+solve(left, mid)+solve(mid,right)
* */
public class maxCoins_312 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                3,1,5,8
        };

        int result = Solution_312.maxCoins(nums);
        System.out.println(result);
    }
}
class Solution_312 {

    private static int[] val;
    private static int[][] allVal;
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n+2];
        for (int i = 0; i < nums.length; i++) {
            val[i+1] = nums[i];
        }
        val[0] = val[n+1] = 1;
        allVal = new int[n+2][n+2];
        for (int i = 0; i < allVal.length; i++) {
            Arrays.fill(allVal[i], -1);
        }
        //在(0, n+1)开区间内进行气球插入
        return dfs(0, n+1);
    }

    public static int dfs(int left, int right) {
        //如果区间不能插入气球，返回0
        if (left >= right-1)
            return 0;
        //如果已经插入过气球,则直接返回
        if (allVal[left][right] != -1)
            return allVal[left][right];
        //枚举(left+1, right-1)区间气球位置
        for (int i = left+1; i < right; i++) {
            int sum = val[left] *val[i] * val[right];
            sum += dfs(left, i) + dfs(i, right);
            allVal[left][right] = Math.max(allVal[left][right], sum);
        }
        return allVal[left][right];
    }
}