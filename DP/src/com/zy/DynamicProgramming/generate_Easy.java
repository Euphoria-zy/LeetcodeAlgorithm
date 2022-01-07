package com.zy.DynamicProgramming;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * code for class generate_Easy
 * @param null
 * 118. 杨辉三角【动态规划——简单】.给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/7 20:21
 **/
public class generate_Easy
{
    public static void main(String[] args)
    {
        int num = 5;
        List<List<Integer>> generate = Solution_IV.generate(num);
        System.out.println(generate);
    }
}

class Solution_IV
{
    public static List<List<Integer>> generate(int numRows)
    {
        int i,j;
        int[][] dp = new int[numRows+1][numRows+1];
        dp[0][0] = 0;
        dp[1][1] = 1;
        if(numRows+1>2)
        {
            dp[2][1] = dp[2][2] = 1;
            for (i = 3; i <= numRows; i++)
            {
                dp[i][1] = 1;
                dp[i][i] = 1;
                for (j = 2; j < i; j++)
                {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(i=1;i<=numRows;i++)
        {
            for(j=1;j<=i;j++)
            {
                current.add(dp[i][j]);
            }
            result.add(current);
            current = new ArrayList<>();
        }
        return result;
    }
}
