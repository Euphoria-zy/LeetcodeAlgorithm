package com.zy.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
* 56. 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
* */
public class merge_56 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 3}, {2, 6}, {8, 10}
        };
        int[][] result = Solution_56.merge(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class Solution_56 {
    public static int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        };
        Arrays.sort(intervals, comparator);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (!answer.isEmpty()) {
                ArrayList<Integer> temp = answer.get(answer.size() - 1);
                int begin = temp.get(0);
                int end = temp.get(1);
                //如果当前区间的左端点大于一合并区间的右端点，则这个区间不能合并;否则合并
                if (end < a) {
                    ArrayList<Integer> newNums = new ArrayList<>();
                    newNums.add(a);
                    newNums.add(b);
                    answer.add(newNums);
                } else if (b >= end){
                    answer.remove(answer.size()-1);
                    ArrayList<Integer> newNums = new ArrayList<>();
                    newNums.add(begin);
                    newNums.add(b);
                    answer.add(newNums);
                }
            } else {
                ArrayList<Integer> newNums = new ArrayList<>();
                newNums.add(a);
                newNums.add(b);
                answer.add(newNums);
            }
        }
        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = new int[] {
                    answer.get(i).get(0), answer.get(i).get(1)
            };
        }
        return result;
    }
}
