package com.zy.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * code for class minimumTotal_Medium
 * @param null
 * 120. 三角形最小路径和【DP】：给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/9/30 14:45
 **/
public class minimumTotal_Medium
{
    public static void main(String[] args)
    {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(-8));
        nums.add(Arrays.asList(3,-6));
        nums.add(Arrays.asList(5,7,1));
        nums.add(Arrays.asList(-9,5,0,-4));
        nums.add(Arrays.asList(-2,4,-1,1,8));
        int result = Solution_32.minimumTotal(nums);
        System.out.println(result);
    }
}
class Solution_32
{
    public static int minimumTotal(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        if (n == 1)
            return dp[0][0];
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i+1 ; j++)
            {
                //左肩膀不存在
                if (j-1 < 0)
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                //右肩膀不存在
                if (j == i)
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                //左肩膀和右肩膀均存在
                if (j-1 >= 0 && j != i)
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if (answer > dp[n-1][i])
                answer = dp[n-1][i];
        return answer;
    }
}