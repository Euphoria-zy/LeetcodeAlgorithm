package com.zy.DepthFirstSearch;
/*
 * code for class invertTree_Easy
 * @param null
 * 226. 翻转二叉树【DFS】
    翻转二叉树，使得以任意结点为根的子树，左子树与右子树对换
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/17 20:36
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
import java.util.ArrayList;

public class invertTree_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_17 solution_17 = new Solution_17();
        TreeNode treeNode = solution_17.invertTree(T.root);
        T.inTraverseTree(treeNode);
        ArrayList<Integer> answer = T.getInOrder();
        for (int i = 0;i<answer.size();i++)
        {
            System.out.print(answer.get(i)+"  ");
        }
    }
}
class Solution_17
{
    public TreeNode invertTree(TreeNode root)
    {
        reverseTree(root);
        return root;
    }
    public void reverseTree(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
                reverseTree(root.left);
            if (root.right != null)
                reverseTree(root.right);
            if (root.left != null && root.right != null)
            {
                TreeNode p1 ;
                TreeNode p2 ;
                p1 = root.left;
                p2 = root.right;
                root.left = p2;
                root.right = p1;
            }
            if (root.left != null && root.right == null)
            {
                TreeNode p ;
                p = root.left;
                root.right = p;
                root.left = null;
            }
            else if (root.left == null && root.right != null)
            {
                TreeNode p ;
                p = root.right;
                root.left = p;
                root.right = null;
            }
            else
                return;
        }
    }
}