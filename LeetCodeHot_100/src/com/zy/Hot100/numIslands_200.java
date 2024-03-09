package com.zy.Hot100;

import java.util.HashSet;
import java.util.Set;

/*
200. 岛屿数量[并查集、深度优先遍历]
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
* */
public class numIslands_200 {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        int result = Solution_200.numIslands(grid);
        System.out.println(result);
    }
}

class Solution_200 {
    public static int[] parent;
    public static int numIslands(char[][] grid) {
        //并查集
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m*n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1')
                    parent[i*n+j+1] = i*n+j+1;
                else
                    parent[i*n+j+1] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union((i - 1) * n + j + 1, i * n + j + 1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union(i * n + j, i * n + j + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(i*n+j+1, (i+1)*n+j+1);
                    }
                    if (j+1 < n && grid[i][j+1] == '1') {
                        union(i*n+j+1, i*n+j+2);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] != 0)
                set.add(findParent(parent[i]));
        }
        int ans1 = set.size();
        int ans2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //深度优先遍历的次数就是岛屿数量
                    ans2++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans2;
    }

    public static void union(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);
        if (parent[x] != parent[y]) {
            parent[parentY] = parentX;
        }
    }

    public static int findParent(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    //深度优先遍历
    public static void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';  //遍历过得位置置为0
        int m = grid.length;
        int n = grid[0].length;
        //沿着四个方向搜索
        if (x-1 >= 0 && grid[x-1][y] == '1')  dfs(x - 1, y, grid);
        if (x+1 < m && grid[x+1][y] == '1')  dfs(x + 1, y, grid);
        if (y-1 >= 0 && grid[x][y-1] == '1')  dfs(x, y-1, grid);
        if (y+1 < n && grid[x][y+1] == '1')  dfs(x, y+1, grid);
    }
}