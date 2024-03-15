package com.zy.Hot100;

/*
338. 比特位计数
给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
分析：利用num & (num-1)可将num的最后一个1变为0
思路一：计算每个i的比特数中1的个数,统计num&(num-1)的次数。时间复杂度为O(nlogn)
思路二：动态规划：对于i。找到比i小的最大最高有效位(2的整数次幂)的数为y，则dp[i] = dp[i-y] + 1。时间复杂度为O(n)
* */
public class countBits_338 {
    public static void main(String[] args) {

    }
}
class Solution_338 {
    public int[] countBits(int n) {
        //1、思路一：计算每个i的比特数中1的个数。时间复杂度为O(nlogn)
        int[] ans1 = new int[n+1];
        ans1[0] = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                if(num % 2 == 1) {
                    count++;
                }
                num = num / 2;
            }
            ans1[i] = count;
        }

        //2、思路二：动态规划。对于i。找到比i小的最大最高有效位(2的整数次幂)的数为y，则dp[i] = dp[i-y] + 1。时间复杂度为O(n)
        int[] ans2 = new int[n+1];
        ans2[0] = 0;
        int maxNum = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            //通过num & (num-1)该运算将 xxx 的二进制表示的最后一个1变成0.顾可以判断是否为2的次幂
            if ((num & (num-1)) == 0) {
                ans2[num] = 1;
                maxNum = num;  //保存最高有效位
            } else {
                ans2[num] = ans2[num-maxNum] + 1;
            }
        }
        return ans2;
    }

}