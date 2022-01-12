package com.zy.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree
{
    public TreeNode root = null;
    //先序序列
    private ArrayList<Integer> preOrder = new ArrayList<>();
    //中序序列
    private ArrayList<Integer> inOrder = new ArrayList<>();
    //后序序列
    private ArrayList<Integer> postOrder = new ArrayList<>();
    //后序序列
    private ArrayList<Integer> levelOrder = new ArrayList<>();

    //采用先序方式构建二叉树
    public TreeNode createTree(TreeNode T)
    {

        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        TreeNode p = null;
        if (a ==-1)
            p = null;
        else
            p = new TreeNode(a);
        T = p;
        if(T==null)
            return T;
        else
        {
            T.left = createTree(T.left);
            T.right = createTree(T.right);
        }
        return T;
    }
    //先序遍历二叉树
    public void preTraverseTree(TreeNode T)
    {
        if (T != null)
        {
            preOrder.add(T.val);
            preTraverseTree(T.left);
            preTraverseTree(T.right);
        }
    }
    //中序序遍历二叉树
    public void inTraverseTree(TreeNode T)
    {
        if (T != null)
        {
            inTraverseTree(T.left);
            inOrder.add(T.val);
            inTraverseTree(T.right);
        }
    }
    //后序遍历二叉树
    public void postTraverseTree(TreeNode T)
    {
        if (T != null)
        {
            postTraverseTree(T.left);
            postTraverseTree(T.right);
            postOrder.add(T.val);
        }
    }
    //层次遍历
    public void levelTraverse(TreeNode T)
    {
        if(T == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(T);
        while(!queue.isEmpty())
        {
            TreeNode p=queue.poll();
            if(p.left!=null)
            {
                queue.offer(p.left);
            }
            if(p.right!=null)
            {
                queue.offer(p.right);
            }
            levelOrder.add(p.val);
        }
    }

    public ArrayList<Integer> getPreOrder()
    {
        return preOrder;
    }

    public void setPreOrder(ArrayList<Integer> preOrder)
    {
        this.preOrder = preOrder;
    }

    public ArrayList<Integer> getInOrder()
    {
        return inOrder;
    }

    public void setInOrder(ArrayList<Integer> inOrder)
    {
        this.inOrder = inOrder;
    }

    public ArrayList<Integer> getPostOrder()
    {
        return postOrder;
    }

    public void setPostOrder(ArrayList<Integer> postOrder)
    {
        this.postOrder = postOrder;
    }

    public ArrayList<Integer> getLevelOrder()
    {
        return levelOrder;
    }

    public void setLevelOrder(ArrayList<Integer> levelOrder)
    {
        this.levelOrder = levelOrder;
    }
}

