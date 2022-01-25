package com.zy.priorityQueue;

/*
 * code for class findRelativeRanks
 * @param null
 * 506. 相对名次【PriorityQueue】
    给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/25 17:18
 **/
import java.util.Arrays;
import java.util.Comparator;

public class findRelativeRanks
{
    public static void main(String[] args)
    {
        int[] source = {10,3,8,9,4};
        Solution_23 solution_23 = new Solution_23();
        String[] result = solution_23.findRelativeRanks(source);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]+"  ");
        }

    }
}
class Solution_23
{
    public String[] findRelativeRanks(int[] score)
    {
        int n = score.length;
        int[][] ans = new int[n][2];
        String[] result = new String[n];
        for (int i = 0; i < n; i++)
        {
            ans[i][0] = score[i];
            ans[i][1] = i;                  //记录每一个成绩对应的序号
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {           //对二维数组按照成绩降序排列
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o2[0] - o1[0] ;
            }
        };
        Arrays.sort(ans, comparator);
        for (int i = 0; i < n; i++)
        {
            System.out.print(ans[i][0]+"  ");
        }
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
                result[ans[i][1]] = "Gold Medal";
            else if (i == 1)
                result[ans[i][1]] = "Silver Medal";
            else if (i == 2)
                result[ans[i][1]] = "Bronze Medal";
            else
                result[ans[i][1]] = i+1+"";
        }
        return result;
    }
}