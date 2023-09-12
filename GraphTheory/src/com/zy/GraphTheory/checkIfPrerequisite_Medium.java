package com.zy.GraphTheory;
/*
 * code for class checkIfPrerequisite_Medium
 * @param null
 * @Description 课程表IV [拓扑排序+floyd]
    数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
    有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
    先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
    你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
    返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/12 9:44
 **/
import java.util.*;

public class checkIfPrerequisite_Medium
{
    public static void main(String[] args)
    {
        int numCourses = 5;
        int[][] prerequisites = new int[][] {
                {0,1},{1,2},{2,3},{3,4}
        };
        int[][] queries = new int[][] {
                {0,4},{4,0},{1,3},{3,0}
        };
        List<Boolean> booleanList = Solution_49.checkIfPrerequisite(numCourses, prerequisites, queries);
        for (boolean value : booleanList)
            System.out.print(value + "  ");
    }
}

class Solution_49 {
    //拓扑排序
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, Integer> trioDegree = new HashMap<>();
        boolean[][] isPre = new boolean[numCourses][numCourses];
        ArrayList<Integer>[] pre = new ArrayList[numCourses];
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            trioDegree.put(i,0);
            pre[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++)
        {
            int last = prerequisites[i][0];
            int next = prerequisites[i][1];
            pre[last].add(next);
            Integer value = trioDegree.get(next);
            trioDegree.put(next, value + 1);
        }
        for (Integer key : trioDegree.keySet()) {
            if (trioDegree.get(key) == 0) {
                zeroQueue.offer(key);
            }
        }
        while (!zeroQueue.isEmpty()){
            int current = zeroQueue.poll();
            for (int node : pre[current]) {
                isPre[current][node] = true;
                for (int i = 0; i < numCourses; i++) {  //枚举中间结点，如果i,j可到达，j,k可到达,则i,k可到达【floyd算法】
                   isPre[i][node] = isPre[i][node] || isPre[i][current];
                }
                trioDegree.put(node,trioDegree.get(node)-1);
                if (trioDegree.get(node) == 0)
                    zeroQueue.offer(node);
            }
        }
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++)
        {
           result.add(isPre[queries[i][0]][queries[i][1]]);
        }

        return result;
    }

    public static int getZeroDegree(Map<Integer, Integer> map) {
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                return key;
            }
        }
        return -1;
    }

}