package com.zy.Hot100;

import java.util.Arrays;
import java.util.Map;

/*
416. 分割等和子集[动态规划]
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
0-1背包问题：元素可以装也可以不装，总重量等于target
定义状态：dp[i][j]:dp[i][j]:在0-i的范围内，选择数字可以使和等于j.
边界条件：
1）边界条件：和为0，不用选择任何正整数：dp[i][0] = true;
2）边界条件，只能选择nums[0]：dp[0][nums[0]] = true;
3）对于nums[i]大于j的情况，则nums[i]不能选择,因此dp[i][j] = dp[i-1][j];
4）对于nums[i]小于j的情况,则nums[i]可以选择也可以不选。两种选择有一个为true即为true。即dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
* */
public class canPartition_416 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                14,9,8,4,3,2
        };
        boolean result = Solution_416.canPartition(nums);
        System.out.println(result);
    }
}
class Solution_416 {
    private static boolean flag;
    private static int[] num;
    public static boolean canPartition(int[] nums) {
        num = Arrays.copyOf(nums, nums.length);
        flag = false;
        //长度小于2，则返回false
        if (nums.length < 2)
            return false;
        int sum = 0;
        int maxNum = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        //数组和为奇数，返回false
        if (sum % 2 != 0)
            return false;
        else {
            int target = sum / 2;
            //数组元素最大值大于target，返回false
            if (maxNum > target)
                return false;
            //数组元素最大值等于target，返回false
            if (maxNum == target)
                return true;
            //dfs(0, 0, target);
            //return flag;
            return dp(nums, target);
        }
    }

    //回溯：枚举每一个元素的状态，选择或不选择。超出时间限制
    public static void dfs(int sum, int index, int target) {
        if (index == num.length)
            return;
        if (sum > target)
            return;
        if (num[index] == target || sum == target) {
            flag = true;
            return;
        } else {
            sum += num[index];
            dfs(sum, index+1, target);
            sum -= num[index];
            dfs(sum, index+1, target);
        }
    }

    public static boolean dp(int[] nums, int target) {
        int n = nums.length;
        //dp[i][j]:在0-i的范围内，选择数字可以使和等于j
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; //边界条件：和为0，不用选择任何正整数
        }
        dp[0][nums[0]] = true; //边界条件，只能选择nums[0]
        //i>0,j>0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < target+1; j++) {
                if (j < nums[i]) {
                    //对于nums[i]大于j的情况，则nums[i]不能选择,因此dp[i][j] = dp[i-1][j];
                    dp[i][j] = dp[i-1][j];
                } else {
                    //对于nums[i]小于j的情况,则nums[i]可以选择也可以不选。两种选择有一个为true即为true。即dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }
}