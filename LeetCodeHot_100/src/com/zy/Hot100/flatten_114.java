package com.zy.Hot100;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
114. 二叉树展开为链表[深度优先遍历]
给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
* */
public class flatten_114 {
    public static void main(String[] args) {

    }
}

class Solution_114 {
    public static List<TreeNode> result;

    public static TreeNode pre;
    public void flatten(TreeNode root) {
        result = new ArrayList<>();
        bfs(result, root);
        //对摘下的节点进行重组
        for (int i = 0; i < result.size()-1; i++) {

            TreeNode current = result.get(i);
            TreeNode next = result.get(i + 1);
            current.left = null;
            current.right = next;
        }
    }
    //方法一：先序遍历保存遍历的节点，然后对节点进行重组，空间复杂度O(n)
    public void bfs(List<TreeNode> preTraverse, TreeNode node) {
        if (node != null) {
            preTraverse.add(node);
            bfs(preTraverse, node.left);
            bfs(preTraverse, node.right);
        }
    }

    //方法二：递归，将左子树接到右子树的位置，右子树接到左子树的最右节点，保证是先序遍历的顺序
    public void traverseTree(TreeNode node) {
        while (node != null) {
            if (node.left == null) {
                //如果左子树为空，直接考虑右子树
                node = node.right;
            } else {

                TreeNode pre = node.left;
                //寻找左子树的最右节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                //最右节点的右子树指向根节点的右子树
                pre.right = node.right;
                //根节点的右子树指向左子树
                node.right = node.left;
                //将左子树置为空
                node.left = null;
                //考虑下一个节点
                node = node.right;
            }
        }
    }

    //方法三：1、采用先序的遍历方式，将树的右子树指向左子树，但是容易丢失右子树。采用后序遍历的思路，只不过是右子树-左子树-根节点的顺序
    //2、倒序遍历，记录上一个遍历的节点。先遍历右子树，然后遍历左子树，把左子树的右指针指向上一个节点，依次进行
    public void postTraverse(TreeNode node) {
        if (node != null) {
            postTraverse(node.right);
            postTraverse(node.left);
            //遍历完右子树，将右指针设置为上一个遍历的节点
            //将左子树置空
            node.right = pre;
            node.left = null;
            //记录上一个遍历的节点
            pre = node;
        }
    }
}