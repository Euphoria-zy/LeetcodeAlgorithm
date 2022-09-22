package com.zy.BackTracking;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
 * code for class generateTrees_Medium
 * @param null
 * 95. 不同的二叉搜索树 II【回溯法】。给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/9/22 10:03
 **/
public class generateTrees_Medium
{
    public static void main(String[] args)
    {
        List<TreeNode> anwser = Solution_28.generateTrees(3);
        for (TreeNode node : anwser)
            System.out.println(node.val);
    }
}
class Solution_28
{
    public static List<TreeNode> generateTrees(int n)
    {
        List<TreeNode> answer = generateTree(1, n);
        return answer;
    }
    //生成从start到end的所有可能二叉树
    public static List<TreeNode> generateTree(int start, int end)
    {
        List<TreeNode> allTree = new LinkedList<>();
        if (start > end){
            allTree.add(null);
            return allTree;
        }
        //以i根节点，生成所有左子树和右子树，将其拼接到根节点上
        for (int i = start;i <= end; i++)
        {
            List<TreeNode> leftTrees = generateTree(start, i-1);
            List<TreeNode> rightTrees = generateTree(i+1, end);
            for (TreeNode left : leftTrees){
                for (TreeNode right: rightTrees){
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = left;
                    currentNode.right = right;
                    allTree.add(currentNode);
                }
            }
        }
        return allTree;
    }
}