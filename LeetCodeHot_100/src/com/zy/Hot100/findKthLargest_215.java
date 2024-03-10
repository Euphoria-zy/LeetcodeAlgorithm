package com.zy.Hot100;

import java.util.Arrays;
import java.util.Map;
/*
215. 数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
* */
public class findKthLargest_215 {
    public static void main(String[] args) {

    }
}

class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        //排序
        Arrays.sort(nums);
        int ans1 = nums[n-k];
        int ans2 = 0;
        ans2 = quickSort(nums, 0, n-1, n-k);
        return ans2;
    }

    

    //快排思想
    public int quickSort(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[k];
        int i = left;
        int j = right;
        int low = nums[left];  //基准元素
        while (i < j) {
            //从右向左找比基准元素小的
            do {
                j--;
            } while (nums[j] > low);

            //从左向右找比基准元素大的
            do {
                i++;
            }
            while (nums[i] < low);
            //交换
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        //循环结束后，i处的元素位置固定
        if (k <= i)
            //如果第k大元素在左边，对左边进行排序
            return quickSort(nums, left, i, k);
        else
            //如果第k大元素在右边，则对右边进行排序
            return quickSort(nums, i+1, right, k);

    }
}
