package com.zy.DepthFirstSearch;

/*
 * code for class maxDepth_Easy
 * @param null
 * 104. 二叉树的最大深度【深度优先搜索】;
    给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/14 11:22
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

public class maxDepth_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_13 solution_13 = new Solution_13();
        int result = solution_13.maxDepth(T.root);
        System.out.println(result);
    }
}
class Solution_13
{
    public static int answer = 0;
    public int maxDepth(TreeNode root)
    {
        int result = 0;
        if (root == null)
            return 0;
        deepSearch(root,1);
        result = answer;
        answer = 0;
        return result;
    }
    public void deepSearch(TreeNode T,int deep)
    {
        if(T.left != null)
            deepSearch(T.left,deep+1);
        if(T.right != null)
            deepSearch(T.right,deep+1);
        if(T.left == null && T.right ==null)
            answer = Math.max(deep,answer);
    }
}