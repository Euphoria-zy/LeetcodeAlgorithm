package com.zy.DynamicProgramming;
/*
 * code for class DynamicProgramming_Medium
 * @param null
 * 376. 摆动序列【DP】:如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/9/27 11:48
 **/
public class DynamicProgramming_Medium
{
    public static void main(String[] args)
    {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int result = Solution_29.wiggleMaxLength(nums);
        System.out.println(result);
    }
}
class Solution_29
{
    public static int wiggleMaxLength(int[] nums)
    {
        int n = nums.length;
        if (n<2)
            return n;
        //up[i]:记录第i个位置以前最长上摆序列的长度
        int[] up = new int[n];
        //down[i]:记录第i个位置以前最长下摆序列的长度
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i<n; i++)
        {
            if (nums[i] < nums[i-1])
            {
                //nums[i]为谷底
                up[i] = up[i-1];
                down[i] = Math.max(down[i-1],up[i-1] +1);
            }else if (nums[i] > nums[i-1])
            {
                //nums[i]为峰
                up[i] = Math.max(up[i-1],down[i-1] + 1);
                down[i] = down[i-1];
            }else
            {
                //一样大的数
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }
}