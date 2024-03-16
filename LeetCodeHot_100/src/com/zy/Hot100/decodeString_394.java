package com.zy.Hot100;

import java.util.Stack;

/*
394. 字符串解码[栈]
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
栈：
遇到左括号、数字、字母压栈；
遇到右括号，依次弹出栈顶字母字符串，拼接成一个字符串，知道遇到左括号，再弹出栈顶数字，对字符串进行循环拼接，然后继续压栈
* */
public class decodeString_394 {

    public static void main(String[] args) {
        Solution_394 solution = new Solution_394();
        String str = "2[abc]3[cd]ef";
        String result = solution.decodeString(str);
        System.out.println(result);
    }
}
class Solution_394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                StringBuilder builder = new StringBuilder();
                //如果是左括号，压栈
                if (s.charAt(i) == '[') {
                    stack.push("[");
                    continue;
                }
                //如果是数字，找到连续数位压栈
                if (isDigital(s.charAt(i))) {
                    builder.append(s.charAt(i));
                    int j = i+1;
                    while (j < s.length() && isDigital(s.charAt(j))) {
                        builder.append(s.charAt(j));
                        j++;
                    }
                    i = j -1;
                    stack.push(builder.toString());
                    continue;
                }
                //如果是字母，找到连续字母压栈
                if (isWord(s.charAt(i))) {
                    builder.append(s.charAt(i));
                    int j = i+1;
                    while (j < s.length() && isWord(s.charAt(j))) {
                        builder.append(s.charAt(j));
                        j++;
                    }
                    i = j - 1;
                    stack.push(builder.toString());
                }
            } else {
                //如果是右括号，弹出字符串，直到遇到左括号
                StringBuilder builder = new StringBuilder();
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    String s1 = stack.pop();
                    temp.insert(0, s1);
                }
                stack.pop();//弹出[
                if (isNumber(stack.peek())) {
                    int count = Integer.parseInt(stack.pop());//弹出数字
                    for (int j = 0; j < count; j++) {
                        builder.append(temp.toString());
                    }
                    //处理完后压栈
                    stack.push(builder.toString());
                }else
                    stack.push(temp.toString());
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            String str = stack.pop();
            builder.insert(0, str);
        }
        return builder.toString();
    }

    public boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public boolean isWord(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public boolean isNumber(String str) {
        try {
            int result = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}