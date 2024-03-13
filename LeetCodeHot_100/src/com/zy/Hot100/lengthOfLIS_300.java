package com.zy.Hot100;

import java.util.Arrays;
import java.util.Comparator;

/*
300. 最长递增子序列[动态规划]
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
dp[i]：以i结尾的最长序列的长度。则dp[i] = max(dp[i], dp[j] + 1),如果nums[i]>nums[j]，即nums[i]能添加到最长升序序列中
* */
public class lengthOfLIS_300 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                1,3,6,7,9,4,10,5,6
        };
        int result = Solution_300.lengthOfLIS(nums);
        System.out.println(result);
    }
}

class Solution_300 {
    public static int lengthOfLIS(int[] nums) {
        //动态规划：dp[i]：以i结尾的最长序列的长度。则dp[i] = max(dp[i], dp[j] + 1)[0<j<i],如果nums[i]>nums[j]，即nums[i]能添加到最长升序序列中
        int n = nums.length;
        int maxLength = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //考虑是否将i添加到以j结尾的序列
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}