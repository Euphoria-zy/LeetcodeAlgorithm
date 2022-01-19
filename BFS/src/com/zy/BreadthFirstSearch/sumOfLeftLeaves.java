package com.zy.BreadthFirstSearch;
/*
 * code for class sumOfLeftLeaves
 * @param null
 * 404. 左叶子之和【BFS】
    计算给定二叉树的所有左叶子之和
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/19 15:26
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class sumOfLeftLeaves
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_18 solution_18 = new Solution_18();
        int result = solution_18.sumOfLeftLeaves(T.root);
        System.out.println(result);
    }
}
class Solution_18
{
    public int sumOfLeftLeaves(TreeNode root)
    {
        Queue<TreeNode> queue =new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int sum = 0;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode p =queue.poll();
            if (p.left != null)
            {
                queue.offer(p.left);
                TreeNode q = p.left;
                if (q.left == null && q.right == null)
                    answer.add(q.val);
            }
            if (p.right != null)
                queue.offer(p.right);
        }
        for (int i = 0; i < answer.size(); i++)
        {
            sum += answer.get(i);
        }
        return sum;
    }
}