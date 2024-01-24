package com.zy.structure;

/*
* 二叉树节点数据结构
* */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int value) {
        this.val = value;
    }
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
