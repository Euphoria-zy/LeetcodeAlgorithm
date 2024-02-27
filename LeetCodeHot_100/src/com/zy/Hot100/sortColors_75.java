package com.zy.Hot100;
/*
75. 颜色分类
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
必须在不使用库内置的 sort 函数的情况下解决这个问题。
* */
public class sortColors_75 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                2,0,2,1,1,0
        };
        Solution_75.sortColors(nums);
    }
}

class Solution_75 {
    public static void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            } else {
                blue++;
            }
        }
        int j = 0;
        while (red > 0) {
            nums[j++] = 0;
            red--;
        }
        while (white > 0) {
            nums[j++] = 1;
            white--;
        }
        while (blue > 0) {
            nums[j++] = 2;
            blue--;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

}