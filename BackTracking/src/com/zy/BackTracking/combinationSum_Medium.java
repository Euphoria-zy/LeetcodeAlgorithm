package com.zy.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * code for class combinationSum_Medium
 * @param null
 * 39. 组合总和【回溯算法】：给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * 【注】candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/9/28 15:06
 **/
public class combinationSum_Medium
{
    public static void main(String[] args)
    {

        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = Solution_30.combinationSum(candidates, target);
        lists.forEach(System.out::println);
    }
}
class Solution_30
{
    public static int targetNum = 0;
    public static List<List<Integer>> answer = new ArrayList();
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        targetNum = target;
        ArrayList<Integer> medium = new ArrayList<>();
        deepSearch(medium,0,candidates,0);
        List<List<Integer>> result = new ArrayList<>();
        //复制结果元素
        for (int i =0 ; i<answer.size(); i++)
        {
            result.add(answer.get(i));
        }
        answer.clear();
        return result;
    }
    public static void deepSearch(ArrayList<Integer> summery,int sum,int[] candidates ,int index)
    {
        //如果结果大于target，则返回
        if (sum > targetNum)
            return;
        if (sum == targetNum)
        {
            //拷贝结果元素
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i< summery.size(); i++)
            {
                ans.add(summery.get(i));
            }
            answer.add(ans);
            return;
        }
        else
        {
            //为保证i位置元素多次回溯，则回溯位置设置为i
            for (int i = index; i < candidates.length; i++)
            {
                summery.add(candidates[i]);
                sum += candidates[i];
                //设置下次回溯位置为i，即当前位置只能从当前往后回溯
                deepSearch(summery,sum,candidates,i);
                //目标集合回溯
                summery.remove(summery.size()-1);
                sum -= candidates[i];
            }
        }
    }
}