package com.zy.DepthFirstSearch;

import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
/*
* 在一个二叉搜索树中，找到目标值为k的元素所在层数，如果不存在则返回-1
* */
public class leaveOfTargetNum_Easy {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = null;
        root = tree.createTree(root);
        int result = Solution_64.fun(root, 6);
        System.out.println(result);
    }
}

class Solution_64 {
    public static int fun(TreeNode root, int k) {
        return findLeave(root, k, 1);
    }

    //T当前节点，k为目标值，leave记录层数
    public static int findLeave(TreeNode T, int k, int leave) {
        int answer = -1;
        if(T != null) {
            if (T.val > k) {
                //当前值大于Target，遍历左子树
                answer = findLeave(T.left, k, leave + 1);
            }
            else if (T.val < k){
                //当前值小于Target，遍历右子树
                answer = findLeave(T.right, k, leave + 1);
            }else {
                //返回当前层
                answer = leave;
            }
            return answer;
        }
        return answer;
    }
}
