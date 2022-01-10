package com.zy.GreedyAlgorithm;

/*
 * code for class increasingTriplet_Medium
 * @param null
 * 334. 递增的三元子序列【贪心算法】
   给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/10 10:10
 **/
import java.util.Stack;

public class increasingTriplet_Medium
{
    public static void main(String[] args)
    {
        int[] nums = {2,1,5,0,4,6};
        boolean result = Solution_9.increasingTriplet(nums);
        System.out.println(result);
    }
}
class Solution_9
{
    public static boolean increasingTriplet(int[] nums)
    {
        int small,middle;                           //small记录三元组中最小的，middle记录三元组中中间大小的元素
        boolean flag = false;
        small = middle = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<small)                       //更新small,
                small = nums[i];
            if (nums[i]>small && nums[i]<middle)        //更新middle
                middle = nums[i];
            if (nums[i]>middle)                         //存在一个数大于middle，则存在三元组
                flag = true;
        }
        return flag;
    }
}