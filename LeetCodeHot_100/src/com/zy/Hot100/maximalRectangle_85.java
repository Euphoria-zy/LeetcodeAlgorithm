package com.zy.Hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
85. 最大矩形
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
{1, 0, 1, 0, 0},
{1, 0, 1, 1, 1},
{1, 1, 1, 1, 1},
{1, 0, 0, 1, 0},
看做柱状图;
第一层柱状图：1, 0, 1, 0, 0
第二层柱状图：2, 0, 2, 1, 1
第三层柱状图：3, 1, 3, 2, 2
第四层柱状图：4, 0, 0, 3, 0
* */
public class maximalRectangle_85 {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int result = Solution_85.maximalRectangle(matrix);
        System.out.println(result);
    }
}


class Solution_85 {
    public static int maximalRectangle(char[][] matrix) {
        //将每一层看做柱状图，依次求每一层的最大矩形
        //1、求当前层柱状图，height[i][j] = matrix[i][j] == 0 ? 0 : matrix[i][j]+ height[i-1][j]
        //2、对每一层采用单调栈求解最大矩形
        int m = matrix.length;
        int n = matrix[0].length;
        int maxRectangleArea = Integer.MIN_VALUE;
        int[][] heights = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] - '0';

                } else {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : matrix[i][j] - '0' + heights[i-1][j];
                }
            }
            maxRectangleArea = Math.max(maxRectangleArea, maxRecTangle(heights[i]));
        }
        return maxRectangleArea;
    }

    //求解柱状图的最大矩形
    public static int maxRecTangle(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();  //左侧柱子
            stack.push(i);
        }
        stack.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();  //右侧柱子
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * height[i]);
        }
        return maxArea;
    }
}