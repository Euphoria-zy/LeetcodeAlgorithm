package com.zy.DynamicProgramming;
/*
 * code for class minPathSum_Medium
 * 【动态规划】
 * 64. 最小路径和.
   给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/6 10:38
 **/
public class minPathSum_Medium
{
    public static void main(String[] args)
    {
        int[][] nums = {
                {1,2,3},
                {4,5,6}
        };
        int result = Solution_III.minPathSum(nums);
        System.out.println(result);
    }
}
class Solution_III
{
    public static int minPathSum(int[][] grid)
    {
        int i,j;
        int m,n;
        m = grid.length;
        n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(i = 1;i< n;i++)
            dp[0][i] = grid[0][i]+dp[0][i-1];
        for(i = 1;i< m;i++)
            dp[i][0] = grid[i][0]+dp[i-1][0];
        for(i=1; i<m;i++)
        {
            for(j=1; j<n;j++)
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}