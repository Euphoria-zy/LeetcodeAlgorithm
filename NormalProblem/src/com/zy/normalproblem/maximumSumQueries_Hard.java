package com.zy.normalproblem;

public class maximumSumQueries_Hard {
    public static void main(String[] args) {

    }
}

class Solution_62 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int maxSum = -1;
            for(int j = 0; j < nums1.length; j++) {
                if(nums1[j] >= x && nums2[j] >= y) {
                    maxSum = Math.max(maxSum, nums1[j] + nums2[j]);
                }
            }
            answer[i] = maxSum;
        }

        return answer;
    }
}