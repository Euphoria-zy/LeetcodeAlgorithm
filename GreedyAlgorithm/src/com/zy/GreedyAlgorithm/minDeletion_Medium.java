package com.zy.GreedyAlgorithm;

import java.util.*;
/*
* 2216. 美化数组的最少删除数【贪心算法】
* */
public class minDeletion_Medium {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,3,3};
        int result = Solution_59.minDeletion(nums);
        System.out.println(result);
    }
}

class Solution_59 {
    public static int minDeletion(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            list.add(num);
        }
        int i = 0;
        while (i < list.size()-1) {
            if(i % 2 == 0 && Objects.equals(list.get(i), list.get(i + 1))) {   //贪心策略，删除坏下标的元素
                list.remove(i);
                count++;
            } else {
                i++;
            }
        }

        if(list.size() % 2 != 0) {  //当长度为奇数时，删除最后一个元素
            list.remove(list.size()-1);
            count++;
        }
        return count;
    }
}