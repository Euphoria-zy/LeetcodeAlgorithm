package com.zy.Hot100;
/*
* 15. 三数之和
* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
* */
import java.util.*;

public class threeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                -1,0,1,2,-1,-4
        };
        List<List<Integer>> results = Solution_15.threeSum(nums);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
class Solution_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return answer;
            //去除重复元素
            if (i-1>=0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
                    answer.add(new ArrayList<>(temp));
                    //去除重复元素
                    while (left+1 < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right-1 > left && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
            }
        }
        return answer;
    }
}