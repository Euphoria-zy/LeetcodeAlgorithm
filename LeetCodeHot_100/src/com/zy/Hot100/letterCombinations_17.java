package com.zy.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合(对应中文九键)。答案可以按 任意顺序 返回。
 * */
public class letterCombinations_17 {
    public static void main(String[] args) {
        String digital = "23";
        List<String> results = Solution_17.letterCombinations(digital);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
class Solution_17 {
    public static String[] digital2 = new String[] {"a", "b", "c"};
    public static String[] digital3 = new String[] {"d", "e", "f"};
    public static String[] digital4 = new String[] {"g", "h", "i"};
    public static String[] digital5 = new String[] {"j", "k", "l"};
    public static String[] digital6 = new String[] {"m", "n", "o"};
    public static String[] digital7 = new String[] {"p", "q", "r", "s"};
    public static String[] digital8 = new String[] {"t", "u", "v"};
    public static String[] digital9 = new String[] {"w", "x", "y", "z"};
    
    public static List<String> answer = new ArrayList<>();
    public static Map<Integer, String[]> digital2Char = new HashMap<>();

    public static String digitals;
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return null;
        digital2Char.put(2, digital2);digital2Char.put(3, digital3);digital2Char.put(4, digital4);digital2Char.put(5, digital5);
        digital2Char.put(6, digital6);digital2Char.put(7, digital7);digital2Char.put(8, digital8);digital2Char.put(9, digital9);
        digitals = digits;
        backTrace(0,"");
        List<String> result = new ArrayList<>(answer);
        answer.clear();
        return result;
    }

    public static void backTrace(int index, String builder) {
        if (builder.length() == digitals.length()) {
            answer.add(builder);
            return;
        } else {
            int digital = digitals.charAt(index) - '0';
            String[] number2Char = digital2Char.get(digital);
            for (int i = 0; i < number2Char.length; i++) {
                String str = number2Char[i];
                builder = builder + str;
                backTrace(index+1, builder);
                builder = builder.substring(0, index);
            }
        }
    }
}