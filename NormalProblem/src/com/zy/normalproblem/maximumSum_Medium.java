package com.zy.normalproblem;

import java.util.*;

public class maximumSum_Medium {
    public static void main(String[] args) {
        int[] nums = new int[] {
                18,43,36,13,7
        };
        int result = Solution_61.maximumSum(nums);
        System.out.println(result);
    }
}
class Solution_61 {
    public static int maximumSum(int[] nums) {
        int maxSum = -1;
        Map<Integer, Integer> map = new HashMap<>();  //键：数位和，值：该数位和对应的数的最大值
        for (int num : nums) {
            int numberSum = getNumberSum(num);
            if (map.containsKey(numberSum)) {
                maxSum = Math.max(maxSum, map.get(numberSum) + num);
                map.put(numberSum, Math.max(map.get(numberSum), num));
            } else {
                map.put(numberSum, num);
            }
        }

        return maxSum;
    }

    public static int getNumberSum(int num) {
        int sum = 0;
        while (num > 0) {
            int a = num / 10;
            int b = num % 10;
            sum += b;
            num = a;
        }
        return sum;
    }
}