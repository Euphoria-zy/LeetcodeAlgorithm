package com.zy.Hot100;

/*
53. 最大子数组和
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
* */
public class maxSubArray_53 {
    public static void main(String[] args) {
        int[] nums = new int[] {

        };
        int result = Solution_53.maxSubArray(nums);
        System.out.println(result);
    }
}
class Solution_53 {
    public static int maxSubArray(int[] nums) {
        //dp：
        //1、计截止到i能找到的最大的子数组和为dp[i]
        //2、如果dp[i-1]>0，表示谦虚加和大于0,则可加上nums[i]，否则从nums[i]开始计数
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
           dp[i] = Math.max(dp[i-1], 0) +nums[i];  //如果dp[i-1]小于0,则从nums[i]开始计数，如果大于0,则累加
           maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}