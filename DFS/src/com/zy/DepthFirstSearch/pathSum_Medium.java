package com.zy.DepthFirstSearch;

/*
 * code for class pathSum_Medium
 * @param null
 * 113. 路径总和 II【深度优先搜索 + 回溯】;
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/15 10:34
 **/
import com.zy.structure.Tree;
import com.zy.structure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class pathSum_Medium
{
    public static void main(String[] args)
    {
        Tree T = new Tree();
        T.root = T.createTree(T.root);
        Solution_14 solution_14 = new Solution_14();
        List<List<Integer>> lists = solution_14.pathSum(T.root, 22);
        for (int i=0;i<lists.size();i++)
        {
            for (int j = 0; j < lists.get(i).size(); j++)
                System.out.print(lists.get(i).get(j) + "  ");
            System.out.println();
        }
    }
}
class Solution_14
{
    public static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        ArrayList<Integer> route = new ArrayList<>();
        List<List<Integer>> result;
        searchTargetSum(root,0,targetSum,route);
        result = (List<List<Integer>>) answer.clone();
        answer.clear();
        return result;
    }
    public void searchTargetSum(TreeNode T, int addSum, int targetSum, ArrayList<Integer> path)
    {
        if (T != null)
        {
            path.add(T.val);
            addSum +=T.val;
            if (T.left != null)
            {
                searchTargetSum(T.left, addSum, targetSum, path);
                path.remove(path.size()-1);
            }
            if (T.right != null)
            {
                searchTargetSum(T.right, addSum, targetSum, path);
                path.remove(path.size()-1);
            }
            if(T.left == null && T.right == null)
            {
                if (addSum == targetSum)
                {
                    ArrayList<Integer> line = new ArrayList<>();
                    line = (ArrayList<Integer>) path.clone();
                    answer.add(line);
                }
            }
        }
    }
}