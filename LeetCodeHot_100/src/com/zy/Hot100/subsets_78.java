package com.zy.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
78. 子集[回溯]
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
[1,2,3] -> [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
* */
public class subsets_78 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = Solution_78.subsets(new int[]{1, 2, 3});
        for (int i = 0; i < subsets.size(); i++) {
            for (int j = 0; j < subsets.get(i).size(); j++) {
                System.out.print(subsets.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }
}

class Solution_78 {
    public static List<List<Integer>> answer = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            backTrace(new ArrayList<>(), nums, i, 0);
        }
        List<List<Integer>> result = new ArrayList<>(answer);
        answer.clear();
        return result;
    }

    public static void backTrace(ArrayList<Integer> temp, int[] nums, int num, int index) {
        if (temp.size() == num) {
            answer.add(new ArrayList<>(temp));
            if (num == 0)
                return;
        } else {
            for (int i = index; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    //从i+1的位置添加元素
                    backTrace(temp, nums, num, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}