package com.zy.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * code for class combinationSum2_Medium
 * @param null
 * 40. 组合总和 II【回溯】：给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。【重点】怎么去重，
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/9/28 17:33
 **/
public class combinationSum2_Medium
{
    public static void main(String[] args)
    {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = Solution_31.combinationSum2(candidates, target);
        lists.forEach(System.out::println);
    }
}
class Solution_31
{
    public static int targetNum = 0;
    public static List<List<Integer>> answer = new ArrayList();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        targetNum = target;
        //排序，将相同的元素放在一起,保证连续的首位元素候选后，后面的元素不被选择.
        Arrays.sort(candidates);
        ArrayList<Integer> medium = new ArrayList<>();
        deepSearch2(medium,0,candidates,0);
        List<List<Integer>> result = new ArrayList<>();
        //复制结果元素
        for (int i =0 ; i< answer.size(); i++)
        {
            result.add(answer.get(i));
        }
        answer.clear();
        return result;
    }
    public static void deepSearch2(ArrayList<Integer> summery,int sum,int[] candidates ,int index)
    {
        //如果结果大于target，则返回
        if (sum > targetNum)
            return;
        if (sum == targetNum)
        {
            //拷贝结果元素
            answer.add(new ArrayList<>(summery));
            return;
        }
        else
        {
            //为保证i位置元素多次回溯，则回溯位置设置为i+1
            for (int i = index; i < candidates.length; i++)
            {
                //相同的元素，如果位居首位的元素没有候选，则后面的元素也不用候选，否则会重复
                if (i > index && candidates[i] == candidates[i-1])
                    continue;
                summery.add(candidates[i]);
                sum += candidates[i];
                //设置下次回溯位置为i+1，保证同一元素不能重复使用
                deepSearch2(summery,sum,candidates,i+1);
                //目标集合回溯
                summery.remove(summery.size()-1);
                sum -= candidates[i];
            }
        }
    }
}