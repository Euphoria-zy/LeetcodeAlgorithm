package com.zy.Hot100;

/*
309. 买卖股票的最佳时机含冷冻期[动态规划]
给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
动态规划：分析每一天结束后的状态：
dp[i][0]:第i天结束后持有股票————第i-1天就有股票dp[i-1][0]或者第i天买入dp[i-1][2]-prices[i](第i-1天不能是冷静期)
dp[i][1]:第i天结束后不持有股票，且处于冷静期————第i天卖股票，第i-1天必须持有股票dp[i-1][0]+prices[i]
dp[i][2]:第i天结束后不持有股票且不处于冷静期————第i天不做任何操作,可能处于冷静期dp[i-1][1](不能买股票),i-1天不持有股票dp[i-1][2](不能卖股票)

* */
public class maxProfit_309 {
    public static void main(String[] args) {
        int[] prices = new int[] {
                1,2,3,0,2
        };
        int result = Solution_309.maxProfit(prices);
        System.out.println(result);
    }
}
class Solution_309 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] profit = new int[n][3];
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        profit[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i-1][0], profit[i-1][2] - prices[i]);
            profit[i][1] = profit[i-1][0] + prices[i];
            profit[i][2] = Math.max(profit[i-1][1], profit[i-1][2]);
        }
        return Math.max(profit[n-1][1], profit[n-1][2]);
    }


}