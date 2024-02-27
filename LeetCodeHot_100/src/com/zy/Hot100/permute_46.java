package com.zy.Hot100;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
46. 全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
*/
public class permute_46 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 2, 3
        };
        List<List<Integer>> results = Solution_46.permute(nums);
        for (int i = 0; i < results.size(); i++) {
            for (Integer value: results.get(i)) {
                System.out.print(value +"  ");
            }
            System.out.println();
        }
    }
}

class Solution_46 {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        backtrace(new ArrayList<>(), nums);
        List<List<Integer>> answer = new ArrayList<>(result);
        result.clear();
        return answer;
    }

    public static void backtrace(ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    backtrace(temp, nums);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}