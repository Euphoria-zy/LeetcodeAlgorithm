package com.zy.Hot100;

/*
32. 最长有效括号:动态规划
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
* */
public class longestValidParentheses_32 {
    public static void main(String[] args) {
        String str = "()(())";
        int result = Solution_32.longestValidParentheses(str);
        System.out.println(result);
    }
}

class Solution_32 {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            //第i个位置为)才为有效括号
            if (s.charAt(i) == ')') {
                //当第i-1个位置为(时，dp[i]= dp[i-2]+2
                if (s.charAt(i-1) == '(')
                    dp[i] = (i-2 >=0 ? dp[i-2]:0) + 2;
                //当第i-1也为)时，考虑i-dp[i-1]-1为(，需考虑dp[i-1]之前的括号是否为有效扩号，此时有效括号为dp[i-1]+2+dp[i-1dp[i-1]-2]
                else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
            }
        }
        int maxLength = 0;
        for (int j = 0; j < n; j++) {
            maxLength = Math.max(maxLength, dp[j]);
        }
        return maxLength;
    }
}