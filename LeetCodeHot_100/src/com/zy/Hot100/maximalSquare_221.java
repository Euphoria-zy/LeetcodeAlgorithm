package com.zy.Hot100;
/*
221. 最大正方形[动态规划]
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
最大正方形取决于最大边长
记dp[i][j]为以i,j为右下角的正方行的最大边长，则dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1])+1
通时，如果i或者j为0，则dp[i][j]=1
* */
public class maximalSquare_221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'},
        };
        int result = Solution_221.maximalSquare(matrix);
        System.out.println(result);
    }
}

class Solution_221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] square = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        square[i][j] = 1;
                    else {
                        square[i][j] = Math.min(Math.min(square[i-1][j-1], square[i-1][j]), square[i][j-1])+1;
                    }
                }
            }
        }
        int maxEdge = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxEdge = Math.max(maxEdge, square[i][j]);
            }
        }
        return (int) Math.pow(maxEdge, 2);
    }
}