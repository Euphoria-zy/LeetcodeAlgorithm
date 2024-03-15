package com.zy.Hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
322. 零钱兑换[动态规划]
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
定义状态：
dp[0] = 0(不需要兑换);dp[i] = amount+1（dp[i]不能被兑换的情况）
dp[i] = max(dp[i-coins[j]] + 1, dp[i]),表示i数量的钱最少需要几个零钱

* */
public class coinChange_322 {
    public static void main(String[] args) {
        int[] coins = new int[] {
                1
        };
        int amount = 0;
        int result = Solution_322.coinChange(coins, amount);
        System.out.println(result);
    }
}
class Solution_322 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        Set<Integer> coin = new HashSet<>();
        for (int i = 0; i < coins.length; i++) {
            coin.add(coins[i]);
        }
        for (int i = 1; i <= amount; i++) {
            for (Integer value : coin) {
                if (i >= value) {
                    dp[i] = Math.min(dp[i-value] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}