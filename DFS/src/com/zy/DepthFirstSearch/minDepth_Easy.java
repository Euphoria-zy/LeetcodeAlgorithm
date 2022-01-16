package com.zy.DepthFirstSearch;

/*
 * code for class minDepth_Easy
 * @param null
 * 111. 二叉树的最小深度【DFS】
    给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/16 12:44
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

public class minDepth_Easy
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_16 solution_16 = new Solution_16();
        int result = solution_16.minDepth(T.root);
        System.out.println(result);
    }
}
class Solution_16
{
    public static int minDepths = Integer.MAX_VALUE;
    public int minDepth(TreeNode root)
    {
        int answer;
        if (root == null)
            return 0;
        DFS_Depth(root,1);
        answer = minDepths;
        minDepths = Integer.MAX_VALUE;
        return answer;
    }
    public void DFS_Depth(TreeNode root,int deep)
    {
        if (root != null)
        {
            if (root.left != null)
                DFS_Depth(root.left ,deep+1);
            if (root.right != null)
                DFS_Depth(root.right ,deep+1);
            if (root.left == null && root.right == null)
            {
                minDepths = Math.min(deep ,minDepths);
            }
        }
    }
}