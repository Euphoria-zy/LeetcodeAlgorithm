package com.zy.DepthFirstSearch;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;

import java.util.Arrays;
/*
*
1457. 二叉树中的伪回文路径:判断从根节点到叶子结点组成路径能否排列为一个回文序列【深度优先遍历 DFS】
* */
public class pseudoPalindromicPaths_Medium {

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = null;
        root = tree.createTree(root);
        int result = Solution_60.pseudoPalindromicPaths(root);
        System.out.println(result);
    }
}

class Solution_60 {
    public static int[] num = new int[10];  //记录路径中节点出现次数
    public static int count = 0;
    public static int pseudoPalindromicPaths (TreeNode root) {
        DFS(root);  //递归方式1
        int result = count;
        count = 0;
        Arrays.fill(num, 0);

        //递归方式2
        int result2 = DFS_1(root, new int[10]);
        System.out.println(result2);
        return result;
    }

    public static void DFS(TreeNode T) {
         if(T != null) {
             num[T.val]++;
             if(T.left != null) {
                 DFS(T.left);
             }
             if(T.right != null) {
                 DFS(T.right);
             }
             if(T.left == null && T.right == null){
                 if (isPalindromic(num))
                     count++;
             }
             num[T.val]--;
         }
    }

    public static int DFS_1(TreeNode node, int[] counter) {
        if (node == null)
            return 0;
        counter[node.val]++;
        int res = 0;
        if (node.left == null && node.right == null) {
            if (isPalindromic(counter))
                res = 1;
        } else {
            res = DFS_1(node.left, counter) + DFS_1(node.right, counter);
        }
        counter[node.val]--;
        return res;
    }

    //如果节点出现次数为偶数或者只有一个为奇数，则能构成回文
    public static boolean isPalindromic(int[] nums) {
        boolean flag = true;
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if (num[i] % 2 != 0) {
                count++;
            }
        }
        if (count > 1) {
            flag = false;
        }
        return flag;
    }
}
