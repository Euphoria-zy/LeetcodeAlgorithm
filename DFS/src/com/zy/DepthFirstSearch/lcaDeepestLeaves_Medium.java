package com.zy.DepthFirstSearch;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;

/*
 * code for class lcaDeepestLeaves_Medium
 * @param null
 * @Description: 1123. 最深叶节点的最近公共祖先
    叶节点 是二叉树中没有子节点的节点
    树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
    如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/6 10:19
 **/
public class lcaDeepestLeaves_Medium
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        TreeNode root = tree.createTree(new TreeNode());
        TreeNode node = Solution_43.lcaDeepestLeaves(root);
        tree.levelTraverse(node);
        ArrayList<Integer> levelOrder = tree.getLevelOrder();
        for (Integer i : levelOrder) {
            System.out.print(i + " ");
        }
    }
}

class Solution_43 {
    private static int deep = Integer.MIN_VALUE;
    private static TreeNode parentNode = null;
    public static TreeNode lcaDeepestLeaves(TreeNode root)
    {
        preOrderTree(root, 0);
        return parentNode;
    }

    public static int preOrderTree(TreeNode node, int index)  //返回值是以node为根节点的子树的高度, index是node结点的深度
    {
        if (node != null) {
            int left = 1 + preOrderTree(node.left, index +1);
            int right = 1 + preOrderTree(node.right, index+1);
            if (left == right) {
                if (deep < index + Math.max(left, right)) {  //深度加上子树的高度等于子树的深度
                    deep = index + Math.max(left, right);
                    parentNode = node;
                }
            }
            return Math.max(left, right);
        } else {
            return 0;
        }
    }
}