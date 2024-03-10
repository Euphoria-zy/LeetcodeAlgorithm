package com.zy.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
207. 课程表[拓扑排序、深度优先遍历]
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
* */
public class canFinish_207 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequistes = new int[][] {
                {1, 0},
                {0, 1}
        };
        boolean result = Solution_207.canFinish(numCourses, prerequistes);
        System.out.println(result);
    }
}

class Solution_207 {
    public static boolean isValid;
    public static int[] isVisited;

    public static List<List<Integer>> edge;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //1、拓扑排序思想，找到前驱为0的节点，删除它的出边，重复该过程，直到遍历完所有节点
        //2、深度优先遍历：该有向图中不存在环，既满足拓扑排序。记录节点遍历状态（0-未遍历，1-遍历中，2-已遍历）
        //3、当一个节点重复在遍历中，则存在环，则不满足拓扑排序
        boolean ans1 = true;
        boolean ans2 = isValid;
        int[][] grid = new int[numCourses][numCourses];
        Map<Integer, Integer> map = new HashMap<>();  //记录每一个节点的前驱数目
        edge = new ArrayList<>();  //保存每个节点的出边
        isValid = true;  //记录是否有环
        isVisited = new int[numCourses];  //记录节点状态
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);  //初始化每一个节点的前驱数目为0
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            grid[b][a] = 1;
            map.put(a, map.getOrDefault(a, 0)+1);
            edge.get(b).add(a);
        }
        //拓扑排序思想
        while (!map.isEmpty()) {
            int classNo = -1;
            for (Integer key : map.keySet()) {
                if (map.get(key) == 0) {
                    classNo = key;  //找一个前驱为0的节点
                    map.remove(key);
                    break;
                }
            }
            if (classNo == -1) {
                break;
            }
            //删除这个点的所有后继
            for (int i = 0; i < grid[classNo].length; i++) {
                if (grid[classNo][i] == 1) {
                    grid[classNo][i] = 0;
                    map.put(i, map.getOrDefault(i, 0)-1);//该点的后继的前驱数目减1
                }
            }
        }
        if (map.isEmpty())
            ans1 = true;
        else
            ans1 = false;
        //深度优先遍历思路
        for (int i = 0; i < numCourses && isValid; i++) {
            if (isVisited[i] == 0)
                dfs(i);
        }
        ans2 = isValid;
        return ans2
    }

    public static void dfs(int node) {
        isVisited[node] = 1;
        for (Integer i : edge.get(node)) {
            //节点i未搜索
            if (isVisited[i] == 0) {
                dfs(i);
                if (!isValid)
                    return;
            } else {
                //节点i已搜索,说明存在环
                isValid = false;
                return;
            }
        }
        isVisited[node] = 2;
    }
}