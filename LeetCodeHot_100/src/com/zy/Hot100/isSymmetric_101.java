package com.zy.Hot100;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.*;

/*
101. 对称二叉树
给你一个二叉树的根节点 root ， 检查它是否轴对称。
* */
public class isSymmetric_101 {
    public static void main(String[] args) {
        Tree T = new Tree();
        TreeNode root = new TreeNode();
        root = T.createTree(root);
        boolean bfs = Solution_101.isSymmetric(root);
        System.out.println(bfs);
    }
}

class Solution_101 {
    public static boolean isSymmetric(TreeNode root) {
        boolean result1 = dfs(root, root);
        boolean result2 = bfs(root, root);
        return result1;
    }

    //1、递归思路：二叉树对称，则树的左子树与另一个树的右子树对称，树的右子树与另一个树的左子树对称
    //2、通过两个指针移动进行比较，p指针指向左子树，则q指针指向右子树;p指针指向右子树，则q指针指向左子树
    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }

    //2、迭代法：将递归思路转化为迭代。依次将一个树的左子树和另一个树的右子树入队，则成镜像的两个点相同;同理将一个树的右子树和另一个树得到左子树入队
    public static boolean bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

}