package com.zy.Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
* 20. 有效的括号
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
* */
public class isValid_20 {
    public static void main(String[] args) {
        boolean valid = Solution_20.isValid("([{}])");
        System.out.println(valid);
    }
}

class Solution_20 {
    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        Stack<String> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //是左括号
            if (map.containsKey(s.charAt(i)+"")) {
                charStack.add(s.charAt(i)+"");
            } else {
                //是右括号
                //如果栈空或者没有左括号，则为false
                if (charStack.empty() || !map.containsKey(charStack.peek())) {
                    return false;
                }
                //如果有左括号，但不匹配，也为false
                String str = map.get(charStack.pop());
                if (!str.equals(s.charAt(i)+""))
                    return false;
            }
        }
        //如果最后栈非空
        if (!charStack.empty())
            return false;
        return true;
    }
}