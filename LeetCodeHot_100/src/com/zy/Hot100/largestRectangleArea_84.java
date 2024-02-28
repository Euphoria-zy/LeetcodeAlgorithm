package com.zy.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
84. 柱状图中最大的矩形[单调栈]
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。[只能是单调增的区域可以勾勒矩形]
* */
public class largestRectangleArea_84 {
    public static void main(String[] args) {
        int[] heights = new int[] {
                2,1,5,6,2,3
        };
        int result = Solution_84.largestRectangleArea(heights);
        System.out.println(result);
    }
}


class Solution_84 {
    public static int largestRectangleArea(int[] heights) {
        //1、暴力枚举左右边界(时间复杂度，O(n^2))
        int n = heights.length;
        int maxArea1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = heights[i];
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea1 = Math.max(maxArea1, minHeight * (j-i+1));
            }
        }

        //2、枚举高度，从高往左右确定左右边界，知道找到比高小的左右柱子(时间复杂度，O(n^2))
        int maxArea2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < n && heights[right] >= heights[i]) {
                right++;
            }
            maxArea2 = Math.max(maxArea2, (right-left-1) * heights[i]);
        }

        //3、单调栈,枚举高度，依靠单调栈寻找左右边界
        //从左往右遍历。维护一个单调增的栈，当height[i]比栈顶小时，一次弹出栈顶元素，知道遇到小于height[i]的j，j则是height[i]的左边界
        //从右往左遍历。维护一个单调增的栈，当height[i]比栈顶小时，一次弹出栈顶元素，知道遇到小于height[i]的j，j则是height[i]的右边界
        int maxArea3 = Integer.MIN_VALUE;
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty()? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxArea3 = Math.max(maxArea3, (right[i] - left[i] -1) * heights[i]);
        }
        return maxArea3;
    }
}