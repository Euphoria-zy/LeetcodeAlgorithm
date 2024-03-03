package com.zy.Hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
139. 单词拆分
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
* */

public class wordBreak_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean result = Solution_139.wordBreak(s, wordDict);
        System.out.println(result);
    }
}

class Solution_139 {
    public static boolean flag;
    public static boolean wordBreak(String s, List<String> wordDict) {
        flag = false;
        Set<String> wordDic = new HashSet<>(wordDict);
        //backtrace(wordDic, "", s, 0);
        dp(wordDic, s);
        return flag;
    }

    //1、回溯写法
    public static void backtrace(Set<String> wordDict, String temp, String s, int length) {
        if (length == s.length()) {
            if (wordDict.contains(temp))
                flag = true;
            return;
        }else {
            if (wordDict.contains(temp)) {
                backtrace(wordDict, s.substring(length, length + 1), s, length + 1);
            }
            backtrace(wordDict, temp + s.charAt(length), s, length + 1);
        }
    }

    //2、动态规划，dp[j] = dp[i] && wordDict.contains(s[i,j])；
    public static void dp(Set<String> wordDict, String s) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        flag = dp[s.length()];
    }
}