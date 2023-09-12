package com.zy.normalproblem;
/*
 * code for class merge_Medium
 * @param null
 * @Description: 56. 合并区间
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/8 13:02
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_Medium
{
    public static void main(String[] args)
    {
        int[][] intervals = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] merge = Solution_45.merge(intervals);
        Solution_45.PrintMatrix(merge);
    }
}
class Solution_45 {
    public static int[][] merge(int[][] intervals) {

        ArrayList<int[]> result = new ArrayList<>();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, comparator);  //排序后可合并的区间肯定是连续的

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            if (intervals[i][0] <= last[1]) {    //将当前区间与已有最后一个区间比较，若区间左端点小于等于最后一个区间的右端点，则重叠，需合并，更新最后一个区间右端点即可。
                last[1] = Math.max(last[1],intervals[i][1]);
                result.remove(result.size()-1);
                result.add(last);
            } else {
                result.add(intervals[i]);   //否则直接将区间加入到答案中
            }
        }
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void PrintMatrix(int[][] merge) {
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.print(merge[i][j] +" ");
            }
            System.out.println();
        }
    }
}