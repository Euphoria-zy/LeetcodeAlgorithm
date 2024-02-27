package com.zy.Hot100;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/*
31. 下一个排列
整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
必须 原地 修改，只允许使用额外常数空间。
123 132 213 231 312 321
* */
public class nextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = new int[] {
          1,2,3
        };
        Solution_31.nextPermutation(nums);
    }
}
class Solution_31 {
    public static void nextPermutation(int[] nums) {
        //1、交换序列中左边的小数与右边的大数可以使序列变大
        //2、交换的小数越靠右得到的序列不是特别大(小数的右边一定是降序)
        //3、交换以后，对小数后续的序列进行排序，降低序列的字典序
        int minIndex = -1;
        for (int i = nums.length-2; i >= 0 ; i--) {
            if (nums[i] < nums[i+1]) {
                minIndex = i;
                break;
            }
        }
        if (minIndex != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[minIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[minIndex];
                    nums[minIndex] = temp;
                    break;
                }
            }
        }

        int left = minIndex == -1 ? 0 : minIndex+1;
        int right = nums.length-1;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        for(int value:nums) {
            System.out.print(value + "  ");
        }
    }
}