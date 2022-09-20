package com.zy.DepthFirstSearch;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.Scanner;

/*
 * code for class hasPathSum_Medium
 * @param null
 * 112. 路径总和：给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/9/20 10:55
 **/
public class hasPathSum_Easy
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode();
        Tree T = new Tree();
        root = T.createTree(root);
        int sum = 0;
        Scanner reader = new Scanner(System.in);
        sum = reader.nextInt();
        boolean result = Solution_27.hasPathSum(root, sum);
        System.out.println(result);
    }

}
class Solution_27 {
    public static int target = 0;
    public static boolean result = false;
    public static boolean hasPathSum(TreeNode root, int targetSum)
    {
        boolean anwser = false;
        target = targetSum;
        DeepSearch(root,0);
        anwser = result;
        result = false;
        return anwser;
    }
    public static void DeepSearch(TreeNode root, int summary)
    {
        if (root != null)
        {
            summary += root.val;
            if (root.left == null && root.right == null && summary == target)
            {
                result = true;
                return;
            }
            else
            {
                DeepSearch(root.left, summary);
                DeepSearch(root.right,summary);
            }
        }
    }
}
