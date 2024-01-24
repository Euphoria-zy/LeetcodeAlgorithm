package com.zy.Hot100;

import java.util.ArrayList;
import java.util.List;
/*
*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的括号组合。
* */
public class generateParenthesis_22 {
    public static void main(String[] args) {
        List<String> results = Solution_22.generateParenthesis(3);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}

class Solution_22 {
    public static List<String> answer = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        backTrace("", 0,0, n);
        List<String> result = new ArrayList<>(answer);
        answer.clear();
        return result;
    }

    public static void backTrace(String builder, int open, int close, int n) {
        if (builder.length() == 2*n) {
            answer.add(builder);
        } else {
            //优先添加左括号
            if (open < n) {
                builder = builder + "(";
                backTrace(builder, open+1, close, n);
                builder = builder.substring(0, builder.length() - 1);
            }
            //在满足括号匹配的情况下，添加右括号
            if (open > close){
                builder = builder + ")";
                backTrace(builder, open, close+1, n);
                builder = builder.substring(0, builder.length() - 1);
            }
        }
    }

}