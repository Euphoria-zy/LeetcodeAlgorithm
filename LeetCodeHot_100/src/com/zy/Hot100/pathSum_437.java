package com.zy.Hot100;

import com.zy.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
437. 路径总和 III
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
* */
public class pathSum_437 {
    public static void main(String[] args) {

    }
}
class Solution_437 {
    public int pathSum(TreeNode root, int targetSum) {
        int ret = 0;
        ret += dfs(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int dfs(TreeNode node, long target) {
        int ret = 0;
        if (node != null) {
            if (node.val == target)
                ret++;
            ret += dfs(node.left, target - node.val);
            ret += dfs(node.right, target - node.val);
            return ret;
        }
        return 0;
    }
}