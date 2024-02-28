package com.zy.Hot100;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
* */
public class inorderTraversal_94 {
    public static void main(String[] args) {

    }
}

class Solution_94 {
    public static List<Integer> answer;
    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        inorder(root);
        return answer;
    }

    public static void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            answer.add(node.val);
            inorder(node.right);
        }
    }
}