package com.zy.DepthFirstSearch;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * code for class inorderTraversal_Easy
 * 94. 二叉树的中序遍历【DFS】
    给定一个二叉树的根节点 root ，返回它的 中序 遍历
 *
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/12 8:42
 **/
public class inorderTraversal_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        ArrayList<Integer> result = new ArrayList<>();
        result = (ArrayList<Integer>) Solution_11.inorderTraversal(T.root);
        System.out.println(result);
    }
}
class Solution_11
{
    private static ArrayList<Integer> answer = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root)
    {
        inTraverseTree(root);
        ArrayList<Integer> result = (ArrayList<Integer>) answer.clone();
        answer.clear();
        return result;
    }
    //中序序遍历二叉树
    public static void inTraverseTree(TreeNode T)
    {
        if (T != null)
        {
            inTraverseTree(T.left);
            answer.add(T.val);
            inTraverseTree(T.right);
        }
    }
}
