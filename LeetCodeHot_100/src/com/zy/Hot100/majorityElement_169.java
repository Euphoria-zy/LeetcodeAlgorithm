package com.zy.Hot100;
/*
169. 多数元素
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* */
public class majorityElement_169 {
    public static void main(String[] args) {

    }
}

class Solution_169 {
    public int majorityElement(int[] nums) {
        //记录maxNum的次数
        int count = 1;
        int maxNum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (count == 0)
                maxNum = nums[i];
            if (nums[i] == maxNum) {
                count++;
            } else {
                //次数抵消
                count--;
            }
        }
        return maxNum;
    }
}
