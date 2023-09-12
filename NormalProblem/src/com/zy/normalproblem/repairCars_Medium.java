package com.zy.normalproblem;
/*
 * code for class repairCars_Medium
 * @param null
 * @Description: 2594. 修车的最少时间
    给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
    同时给你一个整数 cars ，表示总共需要修理的汽车数目。
    请你返回修理所有汽车 最少 需要多少时间。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/7 11:45
 **/

public class repairCars_Medium
{
    public static void main(String[] args)
    {
        int[] ranks = new int[] {4,3,2,1};
        int cars = 10;
        long result = Solution_44.repairCars(ranks, cars);
        System.out.println(result);
    }
}
class Solution_44 {
    public static long repairCars(int[] ranks, int cars) {
        long left = 1; //时间下界
        long right = ranks[0] * cars * cars;//时间上界
        while(left < right) {
            long middle = (left + right) / 2;  //二分查找
            boolean b = checkTime(ranks, middle, cars);  //如果在middle的时间内修车的数量大于cars，则可缩小上界；如果middle时间内修车数量小于cars，则提高下界
            if (b)
                right = middle;
            else
                left = middle + 1;

        }
        return left;
    }

    public static boolean checkTime(int[] ranks, long time, int cars) {
        int sum = 0;
        for (int i = 0; i < ranks.length; i++)
        {
            sum += (long)Math.sqrt(time / ranks[i]);
        }
        if (sum >= cars)
            return true;
        else
            return false;
    }
}