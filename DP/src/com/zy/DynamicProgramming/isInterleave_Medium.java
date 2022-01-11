package com.zy.DynamicProgramming;

/*
 * code for class isInterleave_Medium
 * @param null
 * 97. 交错字符串【动态规划】；
    给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
    两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
      s = s1 + s2 + ... + sn
      t = t1 + t2 + ... + tm
      |n - m| <= 1
      交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/11 8:56
 **/
public class isInterleave_Medium
{
    public static void main(String[] args)
    {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean result = Solution_10.isInterleave(s1,s2,s3);
        System.out.println(result);
    }
}
class Solution_10
{
    public static boolean isInterleave(String s1, String s2, String s3)
    {
        int length1,length2,length3;
        int i,j;
        length1 = s1.length();
        length2 = s2.length();
        length3 = s3.length();
        if (length1 + length2 !=length3)
            return false;
        if (length1 + length2 !=length3)
            return false;
        if(length1 == 0)
            return s3.equals(s2);
        if(length2 == 0)
            return s3.equals(s1);
        if(length3 == 0 && (length1 != 0 || length2 != 0))
            return false;
        boolean[][] dp = new boolean[length1+1][length2+1];
        dp[0][0] = true;
        for(i = 0;i <= length1;i++)
        {
            for(j = 0;j <= length2;j++)
            {
                int p = i+j-1;
                if(i>0)
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s3.charAt(p) == s1.charAt(i-1));
                if(j>0)
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s3.charAt(p) == s2.charAt(j-1));
            }
        }
        return dp[length1][length2];
    }
}