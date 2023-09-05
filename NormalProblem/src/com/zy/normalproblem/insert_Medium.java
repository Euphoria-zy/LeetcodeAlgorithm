package com.zy.normalproblem;
/*
 * code for class insert_Medium
 * @param null
 * @Description 57. 插入区间
    给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
    在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/8/30 21:24
 **/
import java.util.Arrays;
import java.util.Comparator;

public class insert_Medium
{
    public static void main(String[] args)
    {
        int[][] intervals = new int[][] {
                {0,0},{1,3},{5,11}
        };
        int[] newIntervals = new int[]{0,3};
        int[][] insert = Solution_37.insert(intervals, newIntervals);
        PrintArray(insert);
    }

    public static void PrintArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
class Solution_37 {
    public static int[][] insert(int[][] intervals, int[] newInterval)
    {
        int n = intervals.length;
        int left = newInterval[0];
        int right = newInterval[1];
        int[][] temp = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                temp[i][j] = intervals[i][j];
            }
        }
        temp[n][0] = left;
        temp[n][1] = right;
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(temp, comparator);
        int begin, end;
        int[][] result = null;
        for (int i = 0; i < temp.length; i++) {
            begin = end = i;
            if (temp[i][0] == left && temp[i][1] == right)
            {
                if (i - 1 >= 0 && temp[i][0] <= temp[i - 1][1])
                    begin = i - 1;
                if (i - 1 >= 0 && temp[i][1] < temp[i - 1][1])
                    end = i - 1;
                else
                {
                    int k = i + 1;
                    while (k < temp.length && temp[i][1] >= temp[k][0])
                    {
                        k++;
                    }
                    end = k - 1;
                }
                System.out.println("begin:" + begin + "  end:" + end);
                if (end == i - 1)
                {
                    int length = temp.length - 1;
                    result = new int[length][2];
                    for (int j = 0; j <= begin; j++)
                    {
                        for (int l = 0; l < 2; l++)
                        {
                            result[j][l] = temp[j][l];
                        }
                    }
                    for (int j = end + 2; j < temp.length; j++)
                    {
                        for (int l = 0; l < 2; l++)
                        {
                            result[j - 1][l] = temp[j][l];
                        }
                    }
                    return result;
                }
                int length = temp.length - end + begin;
                result = new int[length][2];
                for (int j = 0; j < begin; j++)
                {
                    for (int l = 0; l < 2; l++)
                    {
                        result[j][l] = temp[j][l];
                    }
                }
                if (end != i - 1)
                {
                    for (int j = end + 1; j < temp.length; j++)
                    {
                        for (int l = 0; l < 2; l++)
                        {
                            result[j - end + begin][l] = temp[j][l];
                        }
                    }
                }
                result[begin][0] = temp[begin][0];
                if (temp[i][1] > temp[end][1])
                    result[begin][1] = temp[i][1];
                else
                    result[begin][1] = temp[end][1];
                return result;
            }
        }
        return null;
    }
}