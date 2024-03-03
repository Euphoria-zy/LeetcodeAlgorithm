package com.zy.Hot100;

import com.zy.structure.TreeNode;
/*
124. 二叉树中的最大路径和
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
* */
public class maxPathSum_124 {
    public static void main(String[] args) {

    }
}
class Solution_124 {
    public static int maxLength;
    public static int maxPathSum(TreeNode root) {
        maxLength = Integer.MIN_VALUE;
        maxLength = Math.max(bfs(root), maxLength);
        return maxLength;
    }

    public static int bfs(TreeNode node) {
        if (node != null) {
            //叶节点的贡献度
            if (node.left == null && node.right == null) {
                return node.val;
            } else {
                int length1 = bfs(node.left);
                int length2 = bfs(node.right);
                //考虑左子树或右子树的贡献度
                //左子树为空
                if(length1 == Integer.MIN_VALUE) {
                    //以node为根的最大长度从右子树或者node产生
                    maxLength = max3Num(length2, node.val, maxLength);
                    //对上层的贡献度，贡献右子树+node或仅node
                    return max3Num(length2+node.val, node.val, Integer.MIN_VALUE);
                }
                //右子树为空
                if(length2 == Integer.MIN_VALUE) {
                    //以node节点为根的最大长度从左子树或者node产生
                    maxLength = max3Num(length1, node.val, maxLength);
                    //对上层的贡献度,贡献左子树+node或仅node
                    return max3Num(length1+node.val, node.val, Integer.MIN_VALUE);
                }
                //左右子树均不空
                //最大长度产生路径1：左子树，根节点，右子树
                maxLength = Math.max(maxLength, length1 + length2 + node.val);
                //最大长度产生路径2；左子树、右子树
                maxLength = max3Num(length1, length2, maxLength);
                //node节点值大于0
                if(node.val >= 0)
                    //对上层贡献度，左子树+node、右子树+node、node
                    return max3Num(length1+node.val, length2+node.val, node.val);
                else
                    //node节点值小于0
                    //对上层贡献度，左子树+node、右子树+node、负无穷
                    return max3Num(length1+node.val, length2+node.val, Integer.MIN_VALUE);
            }
        } else
            //若节点为null,对上层贡献度为负无穷
            return Integer.MIN_VALUE;
    }

    public static int max3Num(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}