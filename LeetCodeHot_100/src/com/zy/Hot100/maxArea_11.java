package com.zy.Hot100;
/*
* 11. 盛最多水的容器:双指针法
* 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
* */
public class maxArea_11 {
    public static void main(String[] args) {
        int[] height = new int[] {
                1,8,6,2,5,4,8,3,7
        };
        int result = Solution_11.maxArea(height);
        System.out.println(result);
    }
}

class Solution_11 {
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int width = right - left;
            int high = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width*high);
            //移动短板， 最大面积取决于短板，移动短板只会导致min(height[left], height[right])不变或变大，
            //移动短板，假设h[i]< h[j]，则由s(i,j)可排除s(i,j-1),s(i,j-2)...s(i,i+1)，移动j只能使得min(height[left], height[right])不变或变小，且width变小,故面积一定变小
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}