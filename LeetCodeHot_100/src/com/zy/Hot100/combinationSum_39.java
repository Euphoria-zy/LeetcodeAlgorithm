package com.zy.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 39. 组合总和:回溯
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
* */
public class combinationSum_39 {

    public static void main(String[] args) {
        int [] nums = new int[] {
                8,7,4,3
        };
        int target = 11;
        List<List<Integer>> results = Solution_39.combinationSum(nums, target);
        for (int i = 0; i < results.size(); i++) {
            for (Integer value : results.get(i))
                System.out.print(value+" ");
            System.out.println();
        }
    }
}


class Solution_39 {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, 0, target, 0, new ArrayList<Integer>());
        List<List<Integer>> answer = new ArrayList<>(result);
        result.clear();
        return answer;
    }

    public static void backtrace(int[] candidates, int maxNum, int target, int sum, ArrayList<Integer> temp) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = maxNum; i < candidates.length; i++) {
                temp.add(candidates[i]);
                //下一个起点为i,i之前的元素不再添加，去重
                backtrace(candidates, i, target, sum + candidates[i], temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}