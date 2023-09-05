package com.zy.GraphTheory;
/*
 * code for class minTrioDegree_Medium
 * @param null
 * 1761. 一个图中连通三元组的最小度数
    给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
    一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
    连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
    请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/8/31 14:03
 **/

public class minTrioDegree_Medium
{
    public static void main(String[] args)
    {
        int[][] edges = new int[][] {
                {1,3},{4,3},{4,1},{5,2},{5,6},{6,7},{7,5},{2,6}
        };
        int result = Solution_38.minTrioDegree(7, edges);
        System.out.println(result);
    }
}
class Solution_38 {
    public static int minTrioDegree(int n, int[][] edges)
    {
        int[][] matrix = new int[n+1][n+1];
        int[] degree= new int[n+1];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    degree[i]++;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] == 1) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k] == 1 && matrix[j][k] == 1) {
                            answer = Math.min(answer, degree[i]+degree[j]+degree[k]-6);
                        }
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1:answer;
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