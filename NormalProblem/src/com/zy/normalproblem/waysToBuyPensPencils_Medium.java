package com.zy.normalproblem;
/*
 * code for class waysToBuyPensPencils
 * @param null
 * @Description 2240. 买钢笔和铅笔的方案数
    给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
    请你返回购买钢笔和铅笔的 不同方案数目 。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/1 11:31
 **/
public class waysToBuyPensPencils_Medium
{
    public static void main(String[] args)
    {
        int total = 5;
        int cost1 = 10;
        int cost2 = 10;
        long result = Solution_39.waysToBuyPensPencils(total, cost1, cost2);
        System.out.println(result);
    }
}

class Solution_39
{
    public static long waysToBuyPensPencils(int total, int cost1, int cost2)
    {
        long sum = 0;
        long num1 = total / cost1;  //买钢笔的数目
        //long num2 = total / cost2;
        long k = 0;
        while(k <= num1) {  //枚举每一种钢笔数量下，铅笔的数量
            long num2 = (total - k * cost1) / cost2;
            sum += num2 + 1;
            k++;
        }

        return sum;
    }
}