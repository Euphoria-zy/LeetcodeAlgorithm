package com.zy.Hot100;

import java.util.Arrays;

/*
* 4. 寻找两个正序数组的中位数:排序
* */
public class findMedianSortedArrays_4 {
    public static void main(String[] args) {

    }
}
class Solution_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m+n];
        //合并数组，O(m+n)
        int count = 0;
        int i = 0;
        int j = 0;
        while (nums1[i] < nums2[j] && i < m) {
            num[count++] = nums1[i++];
        }
        while (nums1[i] > nums2[j] && j < n) {
            num[count++] = nums2[j++];
        }
        while (i >= m && j < n) {
            num[count++] = nums2[j++];
        }
        while (i < m && j >= n) {
            num[count++] = nums1[i++];
        }
        if ((m+n) %2 == 0) {
            int x1 = (m+n) /2 -1;
            int x2 = x1+1;
            return (double) (num[x1] + num[x2]) /2;
        } else {
           return (double) num[(m+n)/2];
        }
    }
}