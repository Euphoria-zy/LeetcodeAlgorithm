package com.zy.DynamicProgramming;
//45. 跳跃游戏 II(动态规划)
public class JumpGame
{
    public static void main(String[] args)
    {
        int[] nums = {2,3,0,1,4};
        int result = Solution.jump(nums);
        System.out.println(result);
    }
}
class Solution
{
    public static int jump(int[] nums)
    {
        int i ,j ,minJump;
        int[] dp = new int[nums.length];
        dp[0]=0;
        for(i = 1;i < nums.length ; i++)
        {
            minJump = Integer.MAX_VALUE;
            for(j = 0; j< i ;j++)
            {
                int a = i-j;
                if(nums[j]>=a)
                    minJump = Math.min(minJump,dp[j]+1);
            }
            dp[i] = minJump;
        }
        return dp[i-1];
    }
}