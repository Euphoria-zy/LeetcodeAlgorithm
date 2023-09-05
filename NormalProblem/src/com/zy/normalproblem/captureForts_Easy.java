package com.zy.normalproblem;

import java.util.ArrayList;
import java.util.Map;

public class captureForts_Easy
{
    public static void main(String[] args)
    {
        int[] forts = new int[] {
                0,0,1,-1
        };
        int result = Solution_41.captureForts(forts);
        System.out.println(result);
    }
}
class Solution_41 {
    public static int captureForts(int[] forts)
    {
        ArrayList<Integer> num1 = new ArrayList<>();  //军队位置
        ArrayList<Integer> num2 = new ArrayList<>();   //空闲位置
        //解法一：计算所有的（1，-1）
        for (int i = 0; i < forts.length; i++)
        {
            if (forts[i] == 1)
                num1.add(i);
            if (forts[i] == -1)
                num2.add(i);
        }
        int sum = 0;
        for (int i = 0; i < num1.size(); i++) {
            for (int j = 0; j < num2.size(); j++) {
                boolean serial = true;  //判断1和-1之间的是不是连续的0
                for (int k = Math.min(num1.get(i), num2.get(j)) + 1; k < Math.max(num1.get(i), num2.get(j)); k++) {
                    if (forts[k] != 0) {
                        serial = false;
                    }
                }
                if (serial) {
                    sum = Math.max(sum, Math.abs(num1.get(i) - num2.get(j))-1);
                }
            }
        }

        //解法二：找到相邻的1和-1的最大距离
        int ans = 0;
        int pre = -1; //记录上一个1或-1的位置
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre])
                    ans = Math.max(ans, i - pre - 1);
                pre = i;
            }
        }
        return ans;
        //return sum;
    }
}