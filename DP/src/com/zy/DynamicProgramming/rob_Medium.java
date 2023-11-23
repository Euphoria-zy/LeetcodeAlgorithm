package com.zy.DynamicProgramming;
/*
 * code for class rob_Medium
 * @param null
 * 337. 打家劫舍 III[动态规划/深度优先遍历]
    小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
    除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
    给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/18 11:41
 **/
import com.zy.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class rob_Medium
{
    public static void main(String[] args)
    {
        
    }
}

class Solution_52 {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();  //保存node结点选择时的最大值，记录中间状态
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();  //保存node结点不选择时的最大值，记录中间状态，避免重复计算
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            dfs(node.right);
            f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
            g.put(node, Math.max(f.getOrDefault(node.left,0)+g.getOrDefault(node.left, 0),
                    f.getOrDefault(node.right, 0) + g.getOrDefault(node.right, 0)));
        }
    }
    
}