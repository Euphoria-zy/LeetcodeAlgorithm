package com.zy.Hot100;
/*
* 62. 不同路径: 动态规划
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
* */
public class uniquePaths_62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int result = Solution_62.uniquePaths(m, n);
        System.out.println(result);
    }
}

class Solution_62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第0行只有一种方式到达
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //第0列只有一种方式到达
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //第i行j列由i-1行j列到达或i行j-1列
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}