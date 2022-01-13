package com.zy.DepthFirstSearch;

/*
 * code for class recoverTree_Medium
 * @param null
 * 99. 恢复二叉搜索树【DFS，深度优先搜索】
    给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/13 12:37
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
import java.util.ArrayList;

public class recoverTree_Medium
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_12 object = new Solution_12();
        object.recoverTree(T.root);
        T.inTraverseTree(T.root);
        ArrayList<Integer> inOrder = T.getInOrder();
        for (int i=0;i<inOrder.size();i++)
            System.out.print(inOrder.get(i)+"  ");
    }
}
class Solution_12
{
    ArrayList<Integer> inOrder = new ArrayList<>();
    public void recoverTree(TreeNode root)
    {
        //中序遍历
        inTraverseTree(root);
        //找序列有误的下标
        int[] num = findIndex(inOrder);
        //遍历树恢复树
        inOrder.clear();
        recover(root,2,num[0],num[1]);
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
    //找下标
    public int[] findIndex(ArrayList<Integer> nums)
    {
        int[] swap = new int[2];
        int index1,index2;
        index1 = index2 = -1;
        for(int i = 0;i<inOrder.size()-1;i++)
        {
            if(inOrder.get(i+1)<inOrder.get(i))
            {
                index2 = i+1;
                if (index1 == -1)
                    index1 = i;
                else
                    break;
            }
        }
        swap[0] = nums.get(index1);
        swap[1] = nums.get(index2);
        return swap;
    }
    public void recover(TreeNode root,int count,int x,int y)
    {
        if (root != null)
        {
            if (root.val == x || root.val == y)
            {
                root.val = (root.val == x ? y:x);
                if (--count == 0)
                    return;
            }
            recover(root.left,count,x,y);
            recover(root.right,count,x,y);
        }

    }
}