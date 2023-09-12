package com.zy.GraphTheory;
/*
 * code for class canFinish_Medium
 * @param null
 * @Description: 207. 课程表[拓扑排序]
    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/11 14:54
 **/
import java.util.HashMap;
import java.util.Map;

public class canFinish_Medium
{
    public static void main(String[] args)
    {
        int numCourses = 2;
        int[][] prerequisites = new int[][] {
                {1,0},{0,1}
        };
        boolean canFinish = Solution_46.canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }
}

class Solution_46 {
    public static boolean canFinish(int numCourses, int[][] prerequisites)
    {
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
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][1] == key) {
                        if (trioDegree.containsKey(prerequisites[i][0])) {
                            Integer degree1 = trioDegree.get(prerequisites[i][0]);
                            trioDegree.put(prerequisites[i][0], degree1 - 1);
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static Integer zeroDegreeNode(Map<Integer, Integer> map) {
        for (Integer key: map.keySet()) {
            if (map.get(key) == 0)
                return key;
        }
        return -1;
    }
}