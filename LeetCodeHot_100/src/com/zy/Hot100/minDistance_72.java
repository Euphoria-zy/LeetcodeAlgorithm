package com.zy.Hot100;
/*
* 72. 编辑距离
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符
* */
public class minDistance_72 {
    public static void main(String[] args) {
        String world1 = "horse";
        String world2 = "ros";
        int result = Solution_72.minDistance(world1, world2);
        System.out.println(result);
    }
}

class Solution_72 {
    public static int minDistance(String word1, String word2) {
        //动态规划:dp[i][j]表示word1的第i哥字符到word2的第j哥字符的编辑距离
        //1、A增加一个字符等价于B减少一个字符，A减少一个字符等价于B增加一个字符，A修改一个字符等价于B修改一个字符
        //2、上述操作归结为：A增加一个字符，B增加一个字符，A修改一个字符
        //3、dp[i][j]可由dp[i-1][j](A增加一个字符),dp[i][j-1](B增加一个字符),dp[i-1][j-1](+1)(A修改一个字符,i，j字符不一致则+1)
        //4、dp[0][j] = j, dp[i][0] = 1
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = minThreeNum(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = minThreeNum(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static int minThreeNum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}