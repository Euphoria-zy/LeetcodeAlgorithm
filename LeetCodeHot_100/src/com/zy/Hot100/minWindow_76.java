package com.zy.Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
76. 最小覆盖子串
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
* */
public class minWindow_76 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        String result = Solution_76.minWindow(s, t);
        System.out.println(result);
    }
}

class Solution_76 {
    public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int minLeft;
        int valid = 0;
        Map<String, Integer> sMap = new HashMap<String, Integer>();
        Map<String, Integer> tMap = new HashMap<String, Integer>();
        for (int i = 0; i < t.length(); i++) {
            String charI = t.substring(i, i+1);
            tMap.put(charI, tMap.getOrDefault(charI, 0) + 1);
        }
        int left, right;
        left = right = 0;
        minLeft = -1;
        while (right < s.length()) {
            String current = s.substring(right, right+1);
            if (tMap.containsKey(current)) {
                if (sMap.containsKey(current)) {
                    Integer count = sMap.get(current);
                    count++;
                    sMap.put(current, count);
                } else {
                    sMap.put(current, 1);
                }
                if (Objects.equals(sMap.get(current), tMap.get(current))) {
                    valid++;  //记录窗口的字符串是否包含t的所有字符，缩短sMap和tMap的对比时间
                }
            }
            //收缩窗口
            while (valid == tMap.size()) {
                if (right - left < minLength) {
                    minLeft = left;
                    minLength = right - left + 1;
                }
                String remove = s.substring(left, left+1);
                left++;
                if (sMap.containsKey(remove)) {
                    if (sMap.get(remove).equals(tMap.get(remove))) {
                        valid--; //缩短对比时间
                    }
                    sMap.put(remove, sMap.get(remove)-1);
                }
            }
            right++;
        }
        if (minLength != Integer.MAX_VALUE)
            return s.substring(minLeft, minLeft+minLength);
        else
            return "";
    }
}
