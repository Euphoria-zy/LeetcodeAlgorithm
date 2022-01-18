package com.zy.DepthFirstSearch;
/*
 * code for class flatten_Medium
 * @param null
 * 114. 二叉树展开为链表
    给你二叉树的根结点 root ，请你将它展开为一个单链表：
        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/18 10:30
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class flatten_Medium
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_18 solution_18 = new Solution_18();
        solution_18.flatten(T.root);
        T.preTraverseTree(T.root);
        ArrayList<Integer> answer = T.getPreOrder();
        for (int i = 0; i < answer.size(); i++)
        {
            System.out.print(answer.get(i)+"  ");
        }
    }
}
class Solution_18
{
    public void flatten(TreeNode root)
    {
        List<TreeNode> answer = new ArrayList<TreeNode> ();
        preTraverseTree(root,answer);
        for (int i = 0; i < answer.size()-1; i++)               //重新构建树
        {
            TreeNode pre = answer.get(i);
            TreeNode current = answer.get(i+1);
            pre.left = null;
            pre.right = current;
        }
    }
    public void preTraverseTree(TreeNode T,List<TreeNode> list)         //先序遍历，将节点存储在链表中
    {
        if (T != null)
        {
          list.add(T);
          preTraverseTree(T.left,list);
          preTraverseTree(T.right,list);
        }
    }
}