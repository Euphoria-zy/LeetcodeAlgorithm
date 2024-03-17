package com.zy.Hot100;

import java.util.*;

/*
399. 除法求值[图、深度优先遍历、Floyd]
给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
* */
public class calcEquation_399 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(new String[] {"a", "c"}));
        equations.add(Arrays.asList(new String[] {"b", "e"}));
        equations.add(Arrays.asList(new String[] {"c", "d"}));
        equations.add(Arrays.asList(new String[] {"e", "d"}));
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[] {"a", "b"}));
        double[] values = new double[] {
                2.0,3.0,0.5,5.0
        };
        double[] doubles = Solution_399.calcEquation(equations, values, queries);
        for (double i : doubles)
            System.out.print(i +"  ");
    }
}
class Solution_399 {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Set<String> nodeSet = new HashSet<>();
        Map<String, Integer> nodeMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            if (!nodeSet.contains(s1)) {
                nodeSet.add(s1);
                nodeMap.put(s1, count);
                count++;
            }
            if (!nodeSet.contains(s2)) {
                nodeSet.add(s2);
                nodeMap.put(s2, count);
                count++;
            }
        }
        int n = nodeSet.size();
        double[][] edge = new double[n][n];
        for (int i = 0; i < edge.length; i++) {
            Arrays.fill(edge[i], -1.0);
        }
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double value = values[i];
            int index1 = nodeMap.get(s1);
            int index2 = nodeMap.get(s2);
            edge[index1][index2] = value;
            edge[index2][index1] = 1 / value;
            edge[index1][index1] = 1.0;
            edge[index2][index2] = 1.0;
        }

        //Floyd算法求解任意两点间的距离
        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge.length; j++) {
                for (int k = 0; k < edge[j].length; k++) {
                    if (edge[j][k] == -1.0 && edge[j][i] != -1.0 && edge[i][k] != -1.0) {
                        double distance = edge[j][i] * edge[i][k];
                        edge[j][k] = distance;
                        edge[k][j] = 1 / distance;
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if (!nodeSet.contains(s1) || !nodeSet.contains(s2))
                ans[i] = -1.0;
            else {
                Integer node1 = nodeMap.get(s1);
                Integer node2 = nodeMap.get(s2);
                ans[i] = edge[node1][node2];
            }
        }

        return ans;
    }

}