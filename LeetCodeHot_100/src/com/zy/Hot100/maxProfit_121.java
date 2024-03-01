package com.zy.Hot100;

/*
121. 买卖股票的最佳时机[动态规划]
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
* */
public class maxProfit_121 {
    public static void main(String[] args) {
        int[] prices = new int[] {

        };
        int result = Solution_121.maxProfit(prices);
        System.out.println(result);
    }
}

class Solution_121 {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return Math.max(maxProfit, 0);
    }
}