package com.zy.Hot100;

import com.zy.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
337. 打家劫舍 III
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
深度优先遍历+记忆化搜索：对于node节点，采用两个map记录偷node节点和不偷的情况下的最大金额。
对于每个节点，如果偷了当前节点，则不能偷左子树和右子树；否则可以选择偷左/右子树或者不偷.
* */
public class rob_337 {
    public static void main(String[] args) {

    }
}

class Solution_337 {
    public Map<TreeNode, Integer> robMap;
    public Map<TreeNode, Integer> noRobMap;
    int resul1 = 0;
    int result2 = 0;
    public int rob(TreeNode root) {
        robMap = new HashMap<>();
        noRobMap = new HashMap<>();
        //result1 = Math.max(dfs(root, true), dfs(root, false));
        dfs2(root);
        result2 = Math.max(robMap.getOrDefault(root, 0), noRobMap.getOrDefault(root, 0));
        return result2;
    }

    //深度优先遍历：未保存中间状态，超出时间限制
    public int dfs(TreeNode node, boolean isRob) {
        if (node != null) {
            if (isRob) {
                int sum = node.val + dfs(node.left, false) + dfs(node.right, false);
                robMap.put(node, sum);
                return sum;
            } else {
                int leftMax = Math.max(dfs(node.left, true), dfs(node.left, false));
                int rightMax = Math.max(dfs(node.right, true), dfs(node.right, false));
                return leftMax+rightMax;
            }
        } else
            return 0;
    }

    //在遍历时保存中间状态,记忆化搜索
    public void dfs2(TreeNode node) {
        if (node != null) {
            dfs2(node.left);
            dfs2(node.right);
            //偷当前节点
            robMap.put(node, node.val + noRobMap.getOrDefault(node.left, 0) + noRobMap.getOrDefault(node.right, 0));
            //不偷当前节点：Math.max(偷左子树，不偷左子树)+Math.max(偷右子树，不偷右子树)
            noRobMap.put(node, Math.max(robMap.getOrDefault(node.left, 0),noRobMap.getOrDefault(node.right, 0))+
                    Math.max(robMap.getOrDefault(node.right, 0), noRobMap.getOrDefault(node.right, 0))
                    );
        }
    }
}