package com.zy.Hot100;

import com.zy.structure.TreeNode;
/*
226. 翻转二叉树
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
* */
public class invertTree_226 {
    public static void main(String[] args) {

    }
}

class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    //深度优先遍历：后序遍历树，交换一棵树的左右子树
    public static void invert(TreeNode root) {
        if (root == null)
            return;
        else {
            if (root.left == null && root.right == null) {
                return;
            }
            invert(root.left);
            invert(root.right);
            if (root.left != null && root.right == null) {
                root.right = root.left;
                root.left = null;
                return;
            }
            if (root.left == null && root.right != null) {
                root.left = root.right;
                root.right = null;
                return;
            }
            if (root.left != null && root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                return;
            }

        }
    }
}