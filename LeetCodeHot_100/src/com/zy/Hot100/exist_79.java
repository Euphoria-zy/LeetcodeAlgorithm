package com.zy.Hot100;

import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

import javax.security.auth.Subject;
import java.util.Arrays;

/*
79. 单词搜索
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
* */
public class exist_79 {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        boolean exist = Solution_79.exist(board, "ABCB");
        System.out.println(exist);
    }
}

class Solution_79 {
    public static boolean flag;
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] step = new boolean[m][n];  //标记走过的位置
        flag = false;
        //1、先找到首字母
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //2、在首字母周围进行回溯搜索
                    step[i][j] = true;
                    backTrace(new StringBuilder().append(board[i][j]), i, j, word, m, n, board, step);
                    if (flag)
                        return true;
                    step[i][j] = false;
                }
            }
        }
        return false;
    }

    public static void backTrace(StringBuilder temp, int x, int y, String word, int m, int n, char[][] board, boolean[][] step) {
        if (temp.toString().equals(word)) {
            flag = true;
            return;
        } else {
            //last: 1-上一步在左边， 2-上一步在右边， 3-上一步在上边， 4-上一步在下边
            if (x+1 < m && board[x+1][y] == word.charAt(temp.length()) && !step[x+1][y]) {
                temp.append(board[x+1][y]);
                step[x+1][y] = true;
                backTrace(temp, x+1, y, word, m, n, board, step);
                temp.deleteCharAt(temp.length()-1);
                step[x+1][y] = false;
            }
            if (x-1 >= 0 && board[x-1][y] == word.charAt(temp.length()) && !step[x-1][y]) {
                temp.append(board[x-1][y]);
                step[x-1][y] = true;
                backTrace(temp, x-1, y, word, m, n, board, step);
                temp.deleteCharAt(temp.length()-1);
                step[x-1][y] = false;
            }
            if (y+1 < n && board[x][y+1] == word.charAt(temp.length()) && !step[x][y+1]) {
                temp.append(board[x][y+1]);
                step[x][y+1] = true;
                backTrace(temp, x, y+1, word, m, n, board, step);
                temp.deleteCharAt(temp.length()-1);
                step[x][y+1] = false;
            }
            if (y-1 >= 0 && board[x][y-1] == word.charAt(temp.length()) && !step[x][y-1]) {
                temp.append(board[x][y-1]);
                step[x][y-1] = true;
                backTrace(temp, x, y-1, word, m, n, board, step);
                temp.deleteCharAt(temp.length()-1);
                step[x][y-1] = false;
            }
        }
    }
}