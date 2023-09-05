package com.zy.GreedyAlgorithm;

/*
 * code for class eliminateMaximum_Medium
 * @param null
 * 1921. 消灭怪物的最大数量: 排序

 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/3 17:09
 **/
import java.util.Arrays;
import java.util.Comparator;

public class eliminateMaximum_Medium
{
    public static void main(String[] args)
    {
        int[] dist = new int[] {4,8,6,8,2,7,4};
        int[] speed = new int[] {1,3,3,1,10,1,1};
        int result = Solution_42.eliminateMaximum(dist, speed);
        System.out.println(result);
    }
}
class Solution_42 {
    public static int eliminateMaximum(int[] dist, int[] speed)
    {
        int[][] matrix = new int[dist.length][3];
        for (int i = 0; i < dist.length; i++)
        {
            matrix[i][0] = dist[i];
            matrix[i][1] = speed[i];
            matrix[i][2] = dist[i] / speed[i];
            if (matrix[i][2] * speed[i] < dist[i])
                matrix[i][2] += 1;
        }
        Comparator<int[]> comparator1 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[2] - o2[2];
            }
        };

        Arrays.sort(matrix, comparator1);
        int sum = 0;
        int i = 0;
        for (i = 1; i < dist.length; i++)
        {
            if (matrix[i][0] - i * matrix[i][1] <= 0) {
                sum += i;
                break;
            }

        }
        if (i >= dist.length)
            sum = dist.length;
        if (sum == 0) {
            sum = 1;
        }

        return sum;
    }
}