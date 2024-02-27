package com.zy.Hot100;
/*
* 5. 最长回文子串:动态规划
* 给你一个字符串 s，找到 s 中最长的回文子串。
* */
public class longestPalindrome_5 {
    public static void main(String[] args) {
        String s = Solution_5.longestPalindrome("ababad");
    }
}
class Solution_5 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        int maxLength = 0;
        int begin,end;
        begin = end = 0;
        //dp[i][j]表示从i到j的子串是否为回文子串
        boolean[][] dp = new boolean[n][n];//dp[i][j] = (s[i]==s[j])&& dp[i+1][j-1]
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = L+i-1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    if (maxLength <= j-i+1) {
                        maxLength = j-i+1;
                        begin = i;
                        end= j;
                    }
                }
            }
        }
        return s.substring(begin, end+1);
    }
}