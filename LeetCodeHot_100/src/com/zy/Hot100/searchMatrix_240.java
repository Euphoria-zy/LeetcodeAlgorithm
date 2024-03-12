package com.zy.Hot100;

import java.util.Arrays;

/*
240. 搜索二维矩阵 II[二分查找]
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。每列的元素从上到下升序排列。
* */
public class searchMatrix_240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        boolean result = Solution_240.searchMatrix(matrix, 19);
        System.out.println(result);
    }
}
class Solution_240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //暴力搜索
        //boolean result1 = search1(matrix, target);
        //二分查找
        //boolean result2 = search2(matrix, target);
        //z字搜索
        boolean result3 = search3(matrix, target);
        return result3;
    }
    //暴力搜索，遍历O(mn)
    public static boolean search1(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    //对每一行采用二分查找O(mlogn)
    public static boolean search2(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int[] num = new int[matrix[0].length];
            num = Arrays.copyOf(matrix[i], matrix[0].length);
            if(binarySearch(num, target))
                return true;
        }
        return false;
    }
    //z字搜索O(m+n)
    public static boolean search3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n-1;
        while (x < m && y >=0) {
            if (matrix[x][y] > target) {
                y--;
            }
            if (matrix[x][y] < target) {
                x++;
            }
            if (matrix[x][y] == target) {
                return true;
            }
        }
        return false;
    }

    //二分查找:O(logn)
    public static boolean binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int upper = n-1;
        int mid = (low + upper) / 2;
        while (low <= upper) {
            if (nums[mid] == target) {
                return true;
            }else if (nums[mid] < target){
                low = mid + 1;
            } else
                upper = mid - 1;
            mid = (low+ upper) / 2;
        }
        return false;
    }
}