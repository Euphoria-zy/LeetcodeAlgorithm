package com.zy.GraphTheory;

/*
 * code for class findOrder_Medium
 * @param null
 * @Description 210. 课程表 II
    输出拓扑序列:返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/11 15:17
 **/

import java.util.HashMap;
import java.util.Map;

public class findOrder_Medium
{
    public static void main(String[] args)
    {
        int numCourse = 4;
        int[][] prerequisites = new int[][] {
                {1,0},{2,0},{3,1},{3,2}
        };
        int[] order = Solution_47.findOrder(numCourse, prerequisites);
        for (int value:order)
            System.out.print(value+"  ");

    }
}
class Solution_47 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int index = 0;
        Map<Integer, Integer> trioDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            trioDegree.put(i, 0);
        }
        for (int i = 0; i < prerequisites.length; i++)
        {
            Integer key = prerequisites[i][0];
            Integer degree = trioDegree.get(prerequisites[i][0]);
            trioDegree.put(prerequisites[i][0], degree+1);
        }
        //拓扑排序: 有向无环图中，从某个入度为0的节点出发，删除图中该点和以该点为起点的边；重复该过程，知道图为空或者图中不存在没有前驱的节点；否则，图中一定存在环
        while (!trioDegree.isEmpty()) {
            Integer key = zeroDegreeNode(trioDegree);
            if (key != -1) {
                trioDegree.remove(key);
                result[index] = key;
                index++;
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][1] == key) {
                        if (trioDegree.containsKey(prerequisites[i][0])) {
                            Integer degree1 = trioDegree.get(prerequisites[i][0]);
                            trioDegree.put(prerequisites[i][0], degree1 - 1);
                        }
                    }
                }
            } else {
                return new int[0];
            }
        }
        return result;

    }

    public static Integer zeroDegreeNode(Map<Integer, Integer> map) {
        for (Integer key: map.keySet()) {
            if (map.get(key) == 0)
                return key;
        }
        return -1;
    }


}