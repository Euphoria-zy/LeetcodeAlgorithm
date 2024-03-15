package com.zy.Hot100;

import java.util.*;

/*
347. 前 K 个高频元素[优先队列，小根堆]
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
* */
public class topKFrequent_347 {
    public static void main(String[] args) {

    }
}

class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        //1、采用map统计数字的频率
        //2、采用优先队列，先保存k个频率的数字，后续频率大于队首的元素入队，移除队首元素
        int[] ans = new int[k];
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numCount.get(o1) - numCount.get(o2);
            }
        });

        for (Integer key : numCount.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else {
                if (numCount.get(key) > numCount.get(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.add(key);
                }
            }
        }
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            ans[count] = priorityQueue.remove();
            count++;
        }
        return ans;
    }
}