package com.zy.Hot100;

/*
* 55. 跳跃游戏
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
* */
public class canJump_55 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                3, 2, 1, 1, 0, 4
        };
        boolean result1 = Solution_55.canJump(nums);
        System.out.println(result1);

        boolean result2 = Solution_55.canJump2(nums);
        System.out.println(result2);
    }
}

class Solution_55 {
    public static boolean canJump(int[] nums) {
        int i = nums.length-1;
        int j = i-1;
        while (j >= 0) {
            //从j到i能否到达，如果j能到达i，则前序能到达i的位置一定能到达j，再通过j到达i
            if (i-j <= nums[j]) {
                i = j;
                j = i-1;
            } else {
                j--;
            }
        }
        return i == 0;
    }

    //贪心策略
    //1、对于一个可到达的x，从x可到达的最远距离为x+nums[x]，更新可到达的最远距离
    //2、任何小于最远距离的x都是可到达的，可据此更新可到达的最远距离
    public static boolean canJump2(int[] nums) {
        int maxDistance = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxDistance) {
                maxDistance = Math.max(i+nums[i], maxDistance);
            }
        }
        return maxDistance > nums.length;
    }

}