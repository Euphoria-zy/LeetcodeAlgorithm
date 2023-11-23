package com.zy.DepthFirstSearch;

import com.zy.structure.TreeNode;

public class goodNodes_Medium
{
    public static void main(String[] args)
    {

    }
}
class Solution_51 {

    private static int count = 0;
    public int goodNodes(TreeNode root) {
        preOrder(root, Integer.MIN_VALUE);
        int result = count;
        count = 0;
        return result;
    }

    //先序遍历
    public void preOrder(TreeNode node, int maxNum) {
        if (node != null) {
            if (node.val >= maxNum) {
                count++;
            }
            preOrder(node.left, Math.max(node.val, maxNum));  //遍历左子树，更新当前路径最大值
            preOrder(node.right, Math.max(node.val, maxNum)); //遍历右子树，更新当前路径最大值
        }
    }
}