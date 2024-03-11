package com.zy.Hot100;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
236. 二叉树的最近公共祖先[深度优先遍历]
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：
“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
* */
public class lowestCommonAncestor_236 {
    public static void main(String[] args) {

    }
}

class Solution_236 {
    public static TreeNode parent;
    public static Deque<TreeNode> stack1;  //堆栈采用Deque接口
    public static Deque<TreeNode> stack2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1、方法一：深度优先遍历+栈：保存祖先节点
        //2、方法二：深度优先遍历：
        // 如果root是p,q的最近公共祖先，则1）p和q在root两侧；2）p为root，q在root的左子树或右子树；3）q为root，p在root的左子树或右子树；
        //进行递归。1）如果越过叶节点，则返回null；2）如果root等于p或q，则返回root；3）递归遍历左子树，返回值为left；4）递归遍历右子树，返回值为right；
        //5）如果left=right=null，p和q不在root的左右子树中，返回null；6）如果left!=null && right!=null，p和q最近祖先是root，返回root
        //7）如果left=null,right!=null,则要么p和q都在root右子树，要么只有一个在且right指向p或者q,返回right；8）同理7）
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        dfs(root, p, 1);
        dfs(root, q, 2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.poll();
            TreeNode node2 = stack2.poll();

            if (node1 == node2) {
                parent = node1;
            }
        }
        //方法二：
        TreeNode result2 = dfs2(root, p, q);
        return parent;
    }

    //深度优先遍历，将p的父节点压栈,栈中元素顺序：由p到根节点
    public boolean dfs(TreeNode node, TreeNode p, int index) {
        if (node == null)
            return false;
        if (node == p) {
            if (index == 1)
                stack1.push(node);
            else
                stack2.push(node);
            return true;
        }
        else {
            boolean flag1 = dfs(node.left, p, index);
            boolean flag2 = dfs(node.right, p, index);
            if (flag1 || flag2) {
                if (index == 1)
                    stack1.push(node);
                else
                    stack2.push(node);
                return true;
            } else
                return false;
        }
    }

    public TreeNode dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = dfs2(root.left, p, q);
        TreeNode right = dfs2(root.right, p, q);
        if (left == null && right == null)
            return null;
        if (left == null && right != null)
            return right;
        if (left != null && right == null)
            return left;
        return root;
    }
}