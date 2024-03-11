package com.zy.Hot100;

import java.util.Arrays;

/*
238. 除自身以外数组的乘积[前缀和]
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
* */
public class productExceptSelf_238 {
    public static void main(String[] args) {

    }
}

class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        //1、前缀和：answer = L[i]*R[i]，L[i与R[i]代表i的左侧与右侧元素乘积
        //   很容易通过两次遍历得到L与R，最后再遍历L和R乘积即得到answer。时间复杂度为O(n)，空间复杂度为O(n)
        //2、算法优化：由于answer的空间不计入空间复杂度计算，因此采用answer作为L[i],同时动态计算R[i]
        int n = nums.length;
        int[] answer = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                L[i] = 1;
            else
                L[i] = L[i-1]*nums[i-1];
        }
        for (int i = n-1 i >= 0; i++) {
            if (i == n-1)
                R[i] = 1;
            else
                R[i] = R[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    //空间复杂度优化
    public int[] optimize(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                answer[i] = 1;
            else
                answer[i] = answer[i-1]*nums[i-1];
        }
        int R = 0;
        for (int i = n-1; i >= 0; i--) {
            if (i == n-1)
                R = 1;
            else {
                R = R * nums[i + 1];
                answer[i] = answer[i] * R;
            }
        }
        return answer;
    }
}

