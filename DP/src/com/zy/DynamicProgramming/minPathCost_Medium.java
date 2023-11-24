package com.zy.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
*
2304. 网格中的最小路径代价【动态规划，二维DP】
* */
public class minPathCost_Medium {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {5,3},{4,0},{2,1}
        };
        int[][] moveCost = new int[][] {
                {9,8},{1,5},{10,12},{18,6},{2,4},{14,3}
        };
        int result = Solution_58.minPathCost(grid, moveCost);
        System.out.println(result);
    }
}

class Solution_58 {
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        int result = Integer.MAX_VALUE;
        System.arraycopy(grid[0], 0, cost[0], 0, n);  //数组拷贝

        //dp[i][j] = min(dp[i-1][k]+moveCost[grid[i-1][k]][j] + grid[i][j]), dp[i][j]为到达第i行j列的最小代价
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cost[i][j] = Math.min(cost[i-1][k] + moveCost[grid[i-1][k]][j] + grid[i][j], cost[i][j]);
                }
            }
        }
        for(int i = 0; i < n ; i++) {
            result = Math.min(result, cost[m-1][i]);
        }
        return result;
    }
}