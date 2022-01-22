package com.zy.BreadthFirstSearch;

/*
 * code for class zigzagLevelOrder_Medium
 * @param null
 * 103. 二叉树的锯齿形层序遍历【BFS+双端队列】
    给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/22 20:15
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.*;

public class zigzagLevelOrder_Medium
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_22 solution_22 = new Solution_22();
        List<List<Integer>> lists = solution_22.zigzagLevelOrder(T.root);
        for (int i = 0; i < lists.size() ; i++)
        {
            for (int j = 0; j < lists.get(i).size(); j++)
            {
                System.out.print(lists.get(i).get(j)+"  ");
            }
            System.out.println();
        }
    }
}
class Solution_22
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null )
            return answer;
        int flag = 1;
        int current,next;
        current = 1;
        next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            Deque<Integer> deque = new LinkedList<>();         //通过双端队列改变元素入队次序
            for (int i = 0; i < current; i++)
            {
                TreeNode p = queue.poll();
                if (flag == 1)              //偶数层从队尾入队
                {
                    deque.offerLast(p.val);
                }
                else                            //奇数层队头入队
                    deque.offerFirst(p.val);
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
            }
            current = next;
            next = 0;
            answer.add(new LinkedList<Integer>(deque));
            flag = flag == 1 ? 0: 1;
        }
        return answer;
    }
}