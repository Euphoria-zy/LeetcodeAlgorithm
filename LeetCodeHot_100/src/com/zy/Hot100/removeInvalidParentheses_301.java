package com.zy.Hot100;

import java.util.*;

/*
301. 删除无效的括号[回溯]
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
返回所有可能的结果。答案可以按 任意顺序 返回。
* */
public class removeInvalidParentheses_301 {
    public static void main(String[] args) {
        String str = ")(";
        List<String> stringList = Solution_301.removeInvalidParentheses(str);
        for (String value : stringList)
            System.out.print(value + "  ");
    }
}
class Solution_301 {

    static Set<String> result;
    public static List<String> removeInvalidParentheses(String s) {
        //1、先根据括号匹配的规则求出至少要删除的左括号和右括号的数量，即求得最终字符串的长度
        //2、利用回溯算法求得所有删除l个左括号和r个右括号的字符串

        //1、计算需要移除的左括号和右括号数量
        result = new HashSet<>();
        Stack<String> stack = new Stack<>();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.substring(i, i+1));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    rightCount++;
                    continue;
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                rightCount++;
            }
        }
        if (!stack.isEmpty())
            leftCount = stack.size();

        //回溯移除括号
        backTrace(s, new StringBuilder(), leftCount, rightCount, 0);
        ArrayList<String> answer = new ArrayList<>();
        answer.addAll(result);
        return answer;
    }


    public static void backTrace(String string, StringBuilder builder, int leftCount, int rightCount, int index) {
        if (leftCount == 0 && rightCount == 0 && index == string.length()) {
            //判断是否是有效字符串
            if (isValid(builder.toString())) {
                //使用Set去重
                result.add(builder.toString());
            }
        } else if (leftCount + rightCount > string.length()-index) {
            //如果剩下的字符串不够移除，直接返回
            return;
        }
        else {
            //对字符串的第i个位置进行考察，删除或保留当前位置字符
            if (string.charAt(index) == '(') {
                //尝试删除一个左括号
                if (leftCount > 0) {
                    backTrace(string, builder, leftCount-1, rightCount, index + 1);
                }
            } else if (string.charAt(index) == ')') {
                //尝试删除一个右括号
                if (rightCount > 0) {
                    backTrace(string, builder, leftCount, rightCount-1, index + 1);
                }
            }
            //不删除括号
            builder.append(string.charAt(index));
            backTrace(string, builder, leftCount, rightCount, index+1);
            //移除当前添加结果，重新构建builder
            builder.deleteCharAt(builder.length()-1);
        }
    }

    //判断字符的有效性
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push("(");
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek().equals(")"))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}