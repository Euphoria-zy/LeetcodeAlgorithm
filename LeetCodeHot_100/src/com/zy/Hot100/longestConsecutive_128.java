package com.zy.Hot100;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题
* */
public class longestConsecutive_128 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                100,4,200,1,3,2
        };
        int result = Solution_128.longestConsecutive(nums);
        System.out.println(result);
    }
}


class Solution_128 {
    public static int longestConsecutive(int[] nums) {
        //1、哈希表。遍历nums[i]，对每一个元素，在数组查找存不存在nums[i]+1的数，存在则连续长度+1。查找过程使用哈希表，达到n(1)的复杂度
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentLength = 1;
            //跳过连续段的元素
            if (set.contains(nums[i]-1))
                continue;
            while (set.contains(currentNum+1)) {
                currentLength++;
                currentNum++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}