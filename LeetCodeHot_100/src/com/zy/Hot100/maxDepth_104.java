package com.zy.Hot100;

import com.zy.structure.TreeNode;
/*
104. 二叉树的最大深度
给定一个二叉树 root ，返回其最大深度。
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
* */
public class maxDepth_104 {
    public static void main(String[] args) {

    }
}

class Solution_104 {
    public static int maxDeep;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        maxDeep = Integer.MIN_VALUE;
        dfs(root, 1);
        return maxDeep;
    }

    public void dfs(TreeNode node, int deep) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                maxDeep = Math.max(maxDeep, deep);
            }
            dfs(node.left, deep+1);
            dfs(node.right, deep+1);
        }
    }

    public int maxDeep(TreeNode node) {
        if (node == null)
            return 0;
        else {
            int leftHeight = maxDeep(node.left);
            int rightHeight = maxDeep(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}