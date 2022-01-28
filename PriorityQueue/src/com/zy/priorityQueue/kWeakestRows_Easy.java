package com.zy.priorityQueue;
/*
 * code for class kWeakestRows_Easy
 * @param null
 * 1337. 矩阵中战斗力最弱的K行【优先队列】
    给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
    请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
    如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/28 11:50
 **/
import java.util.Arrays;
import java.util.Comparator;

public class kWeakestRows_Easy
{
    public static void main(String[] args)
    {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k = 3;
        Solution_25 solution_25 = new Solution_25();
        int[] ints = solution_25.kWeakestRows(mat, k);
        for (int i = 0; i < ints.length; i++)
        {
            System.out.print(ints[i]+"  ");
        }

    }
}
class Solution_25
{
    public int[] kWeakestRows(int[][] mat, int k)
    {
        int[][] num = new int[mat.length][2];
        int[] answer = new int[k];
        for (int i = 0; i < mat.length; i++)
        {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++)
            {
                if (mat[i][j] == 1)
                    sum +=1;
            }
            num[i][0] = sum;
            num[i][1] = i;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if ((o1[0] != o2[0]))
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        };
        Arrays.sort(num,comparator);
        for (int i = 0; i < k; i++)
        {
            answer[i] = num[i][1];
        }
        return answer;
    }
}