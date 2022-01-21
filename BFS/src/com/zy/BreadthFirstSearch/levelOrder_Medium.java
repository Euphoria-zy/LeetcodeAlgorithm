package com.zy.BreadthFirstSearch;
/*
 * code for class levelOrder_Medium
 * @param null
 * 102. 二叉树的层序遍历【BFS】
    给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @version 1.0.0
 * @return List<List<Integer>>
 * @author Zhou Yun
 * @date 2022/1/21 10:47
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder_Medium
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_21 solution_21 = new Solution_21();
        List<List<Integer>> result = solution_21.levelOrder(T.root);
        for (int i = 0; i < result.size(); i++)
        {
            for (int j = 0; j < result.get(i).size(); j++)
            {
                System.out.print(result.get(i).get(j)+"  ");
            }
            System.out.println();
        }
    }
}
class Solution_21
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> num = new ArrayList<>();
        queue.offer(root);
        int current,next;
        current= 1;                 //记录当前层的节点个数
        next = 0;                   //记录下一层的节点个数
        while (!queue.isEmpty())
        {
            TreeNode p = queue.poll();
            if (p.left != null)
            {
                queue.offer(p.left);
                next++;
            }
            if (p.right != null)
            {
                queue.offer(p.right);
                next++;
            }
            if (current>0)
            {
                num.add(p.val);
                current--;
            }
            if (current == 0)
            {
                answer.add(num);
                num = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return answer;
    }
}