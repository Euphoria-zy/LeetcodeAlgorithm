package com.zy.DepthFirstSearch;
/*
 * code for class serializeTree_Medium
 * @param null
 * @Description: 449. 序列化和反序列化二叉搜索树
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/5 10:15
 **/
import com.zy.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class serializeTree_Medium
{
    public static void main(String[] args)
    {
        String data = "2 1 3";
        String[] newData = data.replace(","," ").split(" ");

        ArrayList<String> data1 = new ArrayList<>();
        for (int i = 0; i < newData.length; i++)
        {
            if (!newData[i].equals("null"))
                data1.add(newData[i]);
        }

        String data2 = "";
        for (int i = 0; i < data1.size(); i++)
        {
            data2 += data1.get(i) +" ";
        }
        TreeNode deserialize = Codec.deserialize(data2);
        String serialize = Codec.serialize(deserialize);
        System.out.println(serialize.split(" ").length);
        System.out.println(serialize);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public static int[] preStringNum;
    public static int[] inStringNum;
    public static String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        //先序遍历
        preOrder(buffer, root);
        return buffer.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {  //输入树的先序遍历字符串
        data = data.trim();
        String[] chars = data.split(" ");
        System.out.println();
        preStringNum = new int[chars.length];
        inStringNum = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i].equals(""));
            preStringNum[i] = Integer.parseInt(chars[i]);
            inStringNum[i] = preStringNum[i];
        }
        Arrays.sort(inStringNum);
        TreeNode root = new TreeNode();
        if (data == null || data.length() == 0)
            root = null;
        else {
            root.val = preStringNum[0];
            int rootIndex = getRootIndex(preStringNum[0], inStringNum);
            int leftChildLen = rootIndex;
            int rightChildLen = inStringNum.length - leftChildLen -1;
            if (leftChildLen > 0)
                root.left = buildTree(0 + 1, 0 + 1 + leftChildLen -1, 0, rootIndex-1);
            if (rightChildLen > 0)
                root.right = buildTree(0 + leftChildLen + 1, 0 + leftChildLen + 1 + rightChildLen -1, rootIndex+1, rootIndex + rightChildLen);
        }
        return root;
    }

    public static TreeNode buildTree(int preL, int preR, int inL, int inR) {
        TreeNode node = new TreeNode();
        node.val = preStringNum[preL];
        int rootIndex = getRootIndex(preStringNum[preL], inStringNum);
        int leftChildLen = rootIndex - inL;
        int rightChildLen = (inR - inL + 1 - leftChildLen -1);
        if (leftChildLen > 0)
            node.left = buildTree(preL + 1, preL + 1 + leftChildLen-1, inL, rootIndex-1);
        if (rightChildLen > 0)
            node.right = buildTree(preL + leftChildLen + 1, preL + leftChildLen + 1 + rightChildLen -1, rootIndex+1, rootIndex + rightChildLen);
        return node;
    }

    public static void preOrder(StringBuffer result, TreeNode node) {
        if(node != null) {
            result.append(node.val+" ");
            preOrder(result, node.left);
            preOrder(result, node.right);
        }
    }

    public static int getRootIndex(int num1, int[] middle) {
        for (int i = 0; i < middle.length; i++)
        {
            if (num1 == middle[i])
                return i;
        }
        return 0;
    }
}