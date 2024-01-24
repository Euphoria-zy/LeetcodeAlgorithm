package com.zy.Hot100;

import java.util.*;
/*
* 3、最长无重复字符子串
* */
public class lengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        int result = Solution_3.lengthOfLongestSubstring("dvdf");
        System.out.println(result);

    }
}

class Solution_3 {
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<String> strList = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            if (strList.contains(str)) {
                maxLength = Math.max(maxLength, strList.size());
                while (!strList.get(0).equals(str)) {
                    strList.remove(0);
                }
                strList.remove(str);
            }
            strList.add(str);
        }
        maxLength = Math.max(maxLength, strList.size());

        return maxLength;
    }

}