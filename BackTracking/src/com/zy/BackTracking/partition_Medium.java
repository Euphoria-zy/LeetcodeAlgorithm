package com.zy.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * code for class partition_Medium
 * @param null
 * 131. 分割回文串[回溯]：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/10/7 15:08
 **/
public class partition_Medium
{
    public static void main(String[] args)
    {
        String str = "aab";
        List<List<String>> partition = Solution_33.partition(str);
        partition.forEach(System.out::println);
    }
}
class Solution_33
{
    public static List<List<String>> answer;
    public static List<List<String>> partition(String s)
    {
        answer = new ArrayList<>();
        char[] chars = s.toCharArray();
        ArrayList<String> path = new ArrayList<>();
        backTrace(chars, 0 , path);
        List<List<String>> result = new ArrayList<>(answer);
        answer.clear();
        return result;
    }
    public static void backTrace(char[] chars, int startIndex, ArrayList<String> path)
    {
        if (startIndex == chars.length)
        {
            ArrayList<String> ans = new ArrayList<>(path);
            answer.add(ans);
            return;
        }
        for (int i = startIndex; i < chars.length; i++)
        {
            String s = new String(chars, startIndex, i-startIndex+1);
            if (checkPalindroom(s))
            {
                path.add(s);
                backTrace(chars, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean checkPalindroom(String str)
    {
        int i = 0;
        int j = str.length()-1;
        boolean flag = true;
        while (i <= j)
        {
            if (str.charAt(i) != str.charAt(j))
            {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}