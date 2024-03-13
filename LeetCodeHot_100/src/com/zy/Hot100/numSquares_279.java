package com.zy.Hot100;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
279. 完全平方数[动态规划]
给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
dp[i]表示和为i的平方数最小数量：dp[i] = min(dp[i-j*j] + 1)
* */
public class numSquares_279 {
    public static void main(String[] args) {

    }
}

class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        List<Integer> squareNum = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            //i不是平方数
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i-j*j], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}