package com.zy.Hot100;

import javafx.application.Preloader;

/*
* 33. 搜索旋转排序数组: 二分查找
* 整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
* */
public class search_33 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                4,5,6,7,0,1,2
        };
        int target = 0;
        int search = Solution_33.search(nums, target);
        System.out.println(search);
    }
}
class Solution_33 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (left + right) / 2;
        int result = -1;
        while (left <= right) {
            //左边有序
            if (nums[left] <= nums[middle]) {
                //left. middle有序
                result = binarySearch(nums, target, left, middle);
                //middle+1 , right可能有序可能无序，继续二分
                left = middle+1;
            } else {
                //left, middle无序，对middle,right进行二分查找
                result = binarySearch(nums, target, middle, right);
                //left, middle-1可能有序可能无序，继续二分
                right = middle-1;
            }
            middle = (left+right) / 2;
            if (result != -1)
                return result;
        }
        return result;
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        int l = left;
        int r = right;
        int mid = (l + r) / 2;
        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
                mid = (l + r) / 2;
            } else {
                l = mid + 1;
                mid = (l + r) / 2;
            }
        }
        return -1;
    }
}