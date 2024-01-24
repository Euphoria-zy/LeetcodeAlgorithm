package com.zy.Hot100;
/*
* 1、两数相加，nums中两个元素相加之和等于target
* */
public class twoSum_1 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                2,7,11,15
        };
        int target = 9;
        int[] results = Solution_1.twoSum(nums, target);
        System.out.println(results[0]+"  "+results[1]);
    }
}
class Solution_1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return null;
    }
}