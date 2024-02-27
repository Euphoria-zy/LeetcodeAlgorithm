package com.zy.Hot100;

import java.util.*;

/*
* 49. 字母异位词分组
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
* strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
* */
public class groupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> results = Solution_49.groupAnagrams(strs);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
class Solution_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        //构建hashmap,键为排序后的字符串,值为字母异位词。异位词排序后的字符串一致
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = String.valueOf(chars);
            if (strMap.containsKey(string)) {
                List<String> strings = strMap.get(string);
                strings.add(strs[i]);
                strMap.put(string, strings);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                strMap.put(string, temp);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : strMap.keySet()) {
            result.add(strMap.get(key));
        }
        return result;
    }
}