package com.zy.DynamicProgramming;
/*
 * code for class climbStairs_Easy
 * 【动态规划】
 * 70. 爬楼梯.每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/6 10:21
 **/
public class climbStairs_Easy
{
    public static void main(String[] args)
    {
        int result = Solution_II.climbStairs(3);
        System.out.println(result);
    }
}
class Solution_II
{
    public static int climbStairs(int n)
    {
        int i,j;
        int[] dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(i = 2; i<n+1; i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}