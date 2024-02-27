package com.zy.Hot100;

/*
* 34. 在排序数组中查找元素的第一个和最后一个位置: 二分查找.找到第一个nums[mid]>=target的和第一个nums[mid]>target的
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
* */
public class searchRange_34 {
    public static void main(String[] args) {

        int[] nums = new int[] {
                5,7,7,8,8,10
        };
        int target = 6;
        int[] resluts = Solution_34.searchRange(nums, target);
        for (int value : resluts) {
            System.out.print(value + "  ");
        }
    }
}
class Solution_34 {
    public static int[] searchRange(int[] nums, int target) {
        int minIndex = -1;
        int maxIndex = -1;
        int left = 0;
        int right = nums.length-1;
        int middle = (left+right) / 2;
        while (left <= right) {
            if (nums[middle] < target) {
                left = middle+1;
            } else if (nums[middle] > target) {
                right = middle-1;
            } else {
                //先找到target，然后向左二分和向右二分找最小index和最大index
                minIndex = maxIndex = middle;
                int min = binarySearch(nums, target, left, middle-1, 1);
                int max = binarySearch(nums, target, middle+1, right, 2);
                if (min != -1)
                    minIndex = Math.min(min, minIndex);
                if (max != -1)
                    maxIndex = Math.max(max, maxIndex);
                break;
            }
            middle = (left+right) / 2;
        }
        int[] result = new int[] {minIndex, maxIndex};
        return result;
    }

    public static int binarySearch(int[] nums, int target, int left, int right, int flag) {
        int l = left;
        int r = right;
        int mid = (l + r) / 2;
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        while (l <= r) {
            if (nums[mid] == target) {
                if (flag == 1) {
                    //一直向左找最小index
                    minIndex = Math.min(minIndex, mid);
                    r = mid - 1;
                }
                else {
                    //向右找最大index
                    maxIndex = Math.max(maxIndex, mid);
                    l = mid + 1;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        minIndex = minIndex == Integer.MAX_VALUE ? -1 : minIndex;
        maxIndex = maxIndex == Integer.MIN_VALUE ? -1 : maxIndex;
        if (flag == 1)
            return minIndex;
        else
            return maxIndex;
    }
}