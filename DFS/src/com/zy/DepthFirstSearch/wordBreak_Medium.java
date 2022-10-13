package com.zy.DepthFirstSearch;

import java.util.*;

/*
 * code for class wordBreak_Medium
 * @param null
 * 139. 单词拆分[DFS]：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 超时
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/10/13 10:51
 **/
public class wordBreak_Medium
{
    public static void main(String[] args)
    {
        String str = "apple";
        List<String> wordDict = Arrays.asList("apple");
        boolean b = Solution_34.wordBreak(str, wordDict);
        System.out.println(b);
    }
}
class Solution_34
{
    public static List<String> words;
    public static boolean answer = false;
    public static boolean wordBreak(String s, List<String> wordDict)
    {
        words = new ArrayList<>(wordDict);
        //DeepSearchWord(s,0);
        answer = DpWord(s,wordDict);
        boolean result = answer;
        answer = false;
        return result;
    }
    //深度优先遍历，递归判断剩余子串能否由wordDict组成，超时
    public static void DeepSearchWord(String s, int startIndex)
    {
        if (startIndex < s.length() && words.contains(s.substring(startIndex)))
        {
            answer = true;
            return;
        }
        else
        {
            for (int i = startIndex; i< s.length(); i++)
            {
                //分隔从0-i的字符串
                String str = s.substring(startIndex, i+1);
                if (words.contains(str))
                {
                    DeepSearchWord(s,i+1);
                }
            }
        }
    }

    //动态规划O（n^2）复杂度
    public static boolean DpWord(String s, List<String> words)
    {
        Set<String> wordDict = new HashSet<>(words);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}