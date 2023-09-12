package com.zy.GreedyAlgorithm;
/*
 * code for class scheduleCourse_Hard
 * @param null
 * @Description 630. 课程表 III[贪心算法+优先队列]
    这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
    你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
    返回你最多可以修读的课程数目
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/11 17:08
 **/
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class scheduleCourse_Hard
{
    public static void main(String[] args)
    {
        int[][] courses = new int[][] {
                {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
        };
        int result = Solution_48.scheduleCourse(courses);
        System.out.println(result);
    }
}
class Solution_48 {
    public static int scheduleCourse(int[][] courses) {
        Comparator<int[]> comparator1 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(courses, comparator1); //按照课程关闭时间排序，先学习关闭早的课程总是最优的

        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return courses[o2][0] - courses[o1][0];
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator2);
        int time = 0;
        for (int i = 0; i < courses.length; i++)
        {
            if (time + courses[i][0] <= courses[i][1]) {
                priorityQueue.offer(i);   //如果当前可能可学习，则加入优先队列，可学习课程数+1
                time += courses[i][0];
            } else {
                if (courses[priorityQueue.peek()][0] > courses[i][0]) {  //如果当前课程不可学习，则最小化当前学习的时间，为后续课程腾出时间
                    time = time - courses[priorityQueue.poll()][0];  //弹出学习时间最长的课程，选择当前课程进行学习，可学习课程数不变
                    priorityQueue.offer(i);
                    time += courses[i][0];
                }
            }
        }
        return priorityQueue.size();
    }
}