package com.zy.Hot100;

import com.sun.javaws.security.AppContextUtil;
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
105. 从前序与中序遍历序列构造二叉树
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
* */
public class buildTree_105 {
    public static void main(String[] args) {
        int[] preorder = new int[] {
                1,2
        };
        int[] inorder = new int[] {
                1,2
        };
        TreeNode treeNode = Solution_105.buildTree(preorder, inorder);
        Tree T = new Tree();
        T.preTraverseTree(treeNode);
        ArrayList<Integer> preOrder = T.getPreOrder();
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + "  ");
        }
    }
}

class Solution_105 {
    public static int[] preOrder;
    public static Map<Integer, Integer> inOrderMap;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        preOrder = preorder.clone();
        inOrderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode root1 = new TreeNode(preOrder[0]);
        buildBfs(root1, 1, preorder.length-1, 0, inOrderMap.get(preorder[0])-1, inOrderMap.get(preorder[0])+1, inorder.length-1);
        TreeNode root2 = buildBfs2(preorder, 0, preorder.length-1, 0, preorder.length-1);
        return root2;
    }

    //x1,y1：root左右子树的前序序列; x2,y2：root左子树中序序列；x3,y3：root的右子树中序序列
    public static TreeNode buildBfs(TreeNode root, int x1, int y1, int x2, int y2, int x3, int y3) {
        //构建root左子树
        TreeNode left = null;
        if (x1 >= 0 && y2 - x2 + 1 >0) {
            left = new TreeNode(preOrder[x1]);
            int leftIndex = inOrderMap.get(left.val); //左子树根节点的中序位置
            //如果left的子树长度大于0，则构建子树
            if (y2 - x2 > 0)
                left = buildBfs(left, x1+1, y2-x2+x1, x2, leftIndex-1, leftIndex+1, y2);
        }
        //构建root右子树
        TreeNode right = null;
        if (y2-x2+x1+1 < preOrder.length && y3 - x3 + 1 > 0) {
            right = new TreeNode(preOrder[y2 - x2 + x1 + 1]);
            int rightIndex = inOrderMap.get(right.val);
            //如果right的子树长度大于0，则构建子树
            if (y3 - x3 > 0)
                right = buildBfs(right, x1 + y2 - x2 + 2, y1, x3, rightIndex - 1, rightIndex + 1, y3);
        }
        root.left = left;
        root.right = right;
        return root;
    }

    //先序序列，中序序列，先序的左侧，先序的右侧，中序的左侧，中序的右侧
    public static TreeNode buildBfs2(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight)
            return null;
        //构建根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        //定位根节点的中序位置
        Integer inorderRoot = inOrderMap.get(root.val);
        //左子树的长度
        int leftLength = inorderRoot - inorderLeft;
        //构建左子树
        root.left = buildBfs2(preorder, preorderLeft+1, preorderLeft+leftLength, inorderLeft, inorderRoot-1);
        //构建右子树
        root.right = buildBfs2(preorder, preorderLeft+leftLength+1, preorderRight, inorderRoot+1, inorderRight);
        return root;
    }
}