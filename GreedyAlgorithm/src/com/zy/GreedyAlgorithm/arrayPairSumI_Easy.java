package com.zy.GreedyAlgorithm;

import java.util.Arrays;
/*
 * code for class arrayPairSum_Easy
 * @param null
 * 561. 数组拆分I;
    给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
    使得从 1 到n 的 min(ai, bi) 总和最大。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/10 8:11
 **/
public class arrayPairSumI_Easy
{
    public static void main(String[] args)
    {
        int[] nums = {6,2,6,5,1,2};
        int result = Solution_VIII.arrayPairSum(nums);
        System.out.println(result);
    }
}
class Solution_VIII
{
    public static int arrayPairSum(int[] nums)
    {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i=i+2)
        {
            sum += nums[i];
        }
        return sum;
    }
}