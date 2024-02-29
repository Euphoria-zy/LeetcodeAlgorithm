package com.zy.Hot100;

import com.zy.structure.TreeNode;
import javafx.beans.property.ReadOnlyObjectProperty;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.ArrayList;
import java.util.List;

/*
98. 验证二叉搜索树
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
* */
public class isValidBST_98 {
    public static void main(String[] args) {

    }
}


class Solution_98 {
    public static boolean isValidBST(TreeNode root) {

        return isBST(root.left, Long.MIN_VALUE, root.val) && isBST(root.right, root.val, Long.MAX_VALUE);
    }

    //中序遍历，判断序列是否有序
    public static boolean isBST(TreeNode node, long lower, long upper){
        boolean flag1, flag2;
        flag1 = flag2 = true;
        if (node != null) {
            if (node.val >= upper || node.val <= lower)
                return false;
            if (node.left != null) {
                //递归调用：左子树上界改为node.val
                flag1 = isBST(node.left, lower, node.val);
            }
            if (node.right != null) {
                //递归调用：右子树的下界改为node.val
                flag2 = isBST(node.right, node.val, upper);
            }
            return flag1 && flag2;
        } else
            return true;
    }
}