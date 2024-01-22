package com.zy.BackTracking;

import java.util.ArrayDeque;
import java.util.Deque;
/*
* 907. 子数组的最小值之和 动态规划、单调栈
* */
public class sumSubarrayMins_Medium {
    public static void main(String[] args) {
        int[] arr = new int[] {
                3,1,2,4
        };
        int result = Solution_63.sumSubarrayMins(arr);
        System.out.println(result);
    }
}

class Solution_63 {

    public static long MOD = 1000000000 + 7;

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int minSum = 0;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                deque.pop();
            }
            int k = deque.isEmpty() ? i+1 : i - deque.peek();  //寻找以arr[i]结尾的最小元素最长子序列长度
            dp[i] = k * arr[i] + (deque.isEmpty() ? 0 : dp[i-k]);
            minSum = (int) ((minSum + dp[i]) % MOD);
            deque.push(i);
        }
        return minSum;
    }

}