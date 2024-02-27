package com.zy.Hot100;

import java.sql.PreparedStatement;

/*
* 10. 正则表达式匹配:动态规划
* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
* */
public class isMatch_10 {
    public static void main(String[] args) {

    }
}
class Solution_10 {
    public boolean isMatch(String s, String p) {
        boolean flag = true;
        char repeatChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (i < p.length()) {
                if (s.charAt(i) == p.charAt(i) || p.charAt(i) == '.') {
                    continue;
                } else {
                    if (p.charAt(i) == '*') {
                        repeatChar = p.charAt(i-1);
                    }
                    if (s.charAt(i) == repeatChar) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            } else {
                if (s.charAt(i) == repeatChar) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}