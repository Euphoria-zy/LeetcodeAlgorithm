package com.zy.Hot100;

import java.util.HashSet;
import java.util.Set;

/*
136. 只出现一次的数字[稽核]
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
* */
public class singleNumber_136 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        int result = 0;
        for (Integer value : set)
            result = value;
        return result;
    }
}