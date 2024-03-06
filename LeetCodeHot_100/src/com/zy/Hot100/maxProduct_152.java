package com.zy.Hot100;
/*
152. 乘积最大子数组[动态规划]
给你一个整数数组nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
测试用例的答案是一个 32-位 整数。
子数组 是数组的连续子序列。
* */
public class maxProduct_152 {
    public static void main(String[] args) {

    }
}

class Solution_152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //1、定义maxF(i)表示以i结尾的数组的最大乘积
        //2、maxF = max(maxF[i-1]*nums[i], nums[i])，忽略了数的正负性间隔
        //3、考虑正负性，当nums[i]为负数时，应考虑与i-1之前的最小负数相乘
        //4、当nums[i]为正数时，应考虑与i-1之前的最大正数相乘
        //5、采用maxF维护以i结尾的最大乘积，共i以后得正数相乘
        //6、采用minF维护以i结尾的最小乘积，共i以后得负数使用
        int[] maxF = new int[n];
        int[] minF = new int[n];
        maxF[0] = minF[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxF[i] = Math.max(Math.max(maxF[i-1]*nums[i], minF[i-1] * nums[i]), nums[i]);
            minF[i] = Math.min(Math.min(maxF[i-1]* nums[i], minF[i-1]*nums[i]), nums[i]);
        }
        int ans = maxF[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

}