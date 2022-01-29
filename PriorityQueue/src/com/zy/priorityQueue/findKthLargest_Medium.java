package com.zy.priorityQueue;
/*
 * code for class findKthLargest_Medium
 * @param null
 * 215. 数组中的第K个最大元素【优先队列】
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/29 16:23
 **/
import java.util.Arrays;
public class findKthLargest_Medium
{
    public static void main(String[] args)
    {
        int[] nums = {};
        int k = 0;
        Solution_26 solution_26 = new Solution_26();
        int result = solution_26.findKthLargest(nums, k);
        System.out.println(result);
    }
}
class Solution_26
{
    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }
}