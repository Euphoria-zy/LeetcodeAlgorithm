package com.zy.BreadthFirstSearch;
/*
 * code for class getMinimumDifference_Easy
 * @param null
 * 530. 二叉搜索树的最小绝对差
    给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    差值是一个正数，其数值等于两值之差的绝对值。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/21 10:17
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class getMinimumDifference_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_20 solution_20 = new Solution_20();
        int result = solution_20.getMinimumDifference(T.root);
        System.out.println(result);
    }
}
class Solution_20
{
    public List<Integer> inOrder = new ArrayList<>();
    public int getMinimumDifference(TreeNode root)
    {
        inTraverseTree(root);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < inOrder.size()-1; i++)
        {
            int num = Math.abs(inOrder.get(i+1)-inOrder.get(i));
            minDifference = Math.min(minDifference,num);
        }
        inOrder.clear();
        return minDifference;
    }
    public void inTraverseTree(TreeNode T)
    {
        if (T != null)
        {
            inTraverseTree(T.left);
            inOrder.add(T.val);
            inTraverseTree(T.right);
        }
    }
}