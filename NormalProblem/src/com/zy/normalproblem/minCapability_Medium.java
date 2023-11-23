package com.zy.normalproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * code for class minCapability_Medium
 * @param null
 * @Description
    2560. 打家劫舍 IV [二分查找]
    沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
    由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
    小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
    给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
    另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
    返回小偷的 最小 窃取能力。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/19 9:35
 **/
public class minCapability_Medium
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {};
        int k = 3;
        int result = Solution_53.minCapability(nums, k);
        System.out.println(result);
    }
}
class Solution_53 {
    public static int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();   //最小金额
        int upper = Arrays.stream(nums).max().getAsInt();   //最大金额
        int middle = (lower + upper) / 2;
        while (lower <= upper) {
            boolean visiable = false;
            int count = 0;
            for (int x : nums) {     //记录在金额middle限制下，能盗窃的房子数目
                if (x < middle) {
                    visiable = true;   //保证不连续盗窃
                    count++;
                } else {
                    visiable = false;
                }
            }
            if (count >= k) {         //如果盗窃数目大于k，则降低金额上限
                upper = middle - 1;
            } else
                lower = middle + 1;    //盗窃数目小于k,提高金额下限
        }
        return lower;
    }
}