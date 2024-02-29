package com.zy.Hot100;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
102. 二叉树的层序遍历
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
* */
public class levelOrder_102 {
    public static void main(String[] args) {
        Tree T = new Tree();
        TreeNode root = new TreeNode();
        root = T.createTree(root);
        List<List<Integer>> lists = Solution_102.levelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) +"  ");
            }
            System.out.println();
        }
    }
}

class Solution_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            result.add(temp);
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            current--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (current == 0) {
                result.add(new ArrayList<>(temp));
                temp.clear();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}