package com.zy.Hot100;

/*
96. 不同的二叉搜索树[动态规划]
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//以i为根的二叉搜索树，种类为以i-1的节点为左子树的种数乘以number-i为节点的右子树的种数
定义G(n)为以n为根的二叉搜索树个数，则G(n) = F(i,n),
F(i,n)表示以i为根，长度为n的二叉搜索树个数，则F(i,n) = G(i-1)*G(n-i)
则G(n) = SUM[G(i-1)*G(n-i)], i = 1...n
* */
public class numTrees_96 {
    public static void main(String[] args) {
        int n = 3;
        int result = Solution_96.numTrees(n);
        System.out.println(result);
    }
}

class Solution_96 {
    public static int numTrees(int n) {
        int[] numberTree = new int[n+1];
        return dfs(numberTree, n);
    }

    public static int dfs(int[] number, int n) {
        int count = 0;
        number[0] = number[1] = 1;
        if (number[n] != 0) {
            return number[n];
        }
        else {
            //求解G(n) += G(i-1)*G(n-i)
            for (int i = 1; i <= n; i++) {
                //以i为根的二叉树种类：左子树种数乘以右子树种数
                count += dfs(number, i-1) * dfs(number, n - i);
            }
            number[n] = count;
        }
        return number[n];
    }
}