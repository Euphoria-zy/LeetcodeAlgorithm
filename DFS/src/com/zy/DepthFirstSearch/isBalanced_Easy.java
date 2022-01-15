package com.zy.DepthFirstSearch;
/*
 * code for class isBalanced_Easy
 * @param null
 * 110. 平衡二叉树【深度优先搜索】
    给定一个二叉树，判断它是否是高度平衡的二叉树【左子树和右子树的高度差不高过1】。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/15 15:24
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

public class isBalanced_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_15 solution_15 = new Solution_15();
        boolean result = solution_15.isBalanced(T.root);
        System.out.println(result);
    }
}
class Solution_15
{
    public static boolean flag = true;
    public boolean isBalanced(TreeNode root)
    {
        boolean result = false;
        if (root == null)
            return true;
        dfsBalance(root,0,0);
        result = flag;
        flag = true;
        return result;
    }
    public int dfsBalance(TreeNode root ,int leftHigh ,int rightHigh)
    {
        if (root.left != null)                                      //左子树的高度
        {
            leftHigh = dfsBalance(root.left ,leftHigh, rightHigh);
        }
        else
            leftHigh = 0;
        if (root.right != null)                                     //右子树的高度
        {
            rightHigh = dfsBalance(root.right ,leftHigh, rightHigh);
        }
        else
            rightHigh = 0;
        if(Math.abs(leftHigh-rightHigh)>1)                          //当有一个结点不满足，就不是平衡二叉树
            flag = false;
        return Math.max(leftHigh,rightHigh)+1;                      //当前结点的高度为左子树和右子树最大高度加1
    }
}