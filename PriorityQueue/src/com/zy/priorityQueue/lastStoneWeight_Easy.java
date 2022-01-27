package com.zy.priorityQueue;
/*
 * code for class lastStoneWeight_Easy
 * @param null
 * 1046. 最后一块石头的重量【优先队列】
   每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
        如果x == y，那么两块石头都会被完全粉碎；
        如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/27 10:28
 **/
import java.util.Comparator;
import java.util.PriorityQueue;

public class lastStoneWeight_Easy
{
    public static void main(String[] args)
    {
        int[] stones = {1};
        Solution_24 solution_24 = new Solution_24();
        int result = solution_24.lastStoneWeight(stones);
        System.out.println(result);
    }
}
class Solution_24
{
    public int lastStoneWeight(int[] stones)
    {
        Comparator<Integer> comparator = new Comparator<Integer>() {            //重量由高到低排列
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < stones.length; i++)
        {
            priorityQueue.offer(stones[i]);
        }
        while (priorityQueue.size() > 1)
        {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if (x != y)
            {
                int a = x - y;
                priorityQueue.offer(a);
            }
        }
        if (priorityQueue.isEmpty())
            return 0;
        else
            return priorityQueue.poll();
    }
}