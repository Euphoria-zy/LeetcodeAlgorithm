package com.zy.Hot100;

import com.zy.structure.TreeNode;
/*
297. 二叉树的序列化与反序列化[深度优先遍历]
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
* */
import java.util.*;

public class Codec_297 {
    public static void main(String[] args) {

    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfsSerialize(root, result);
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVal = data.split(",");
        ArrayList<String> node = new ArrayList<>(Arrays.asList(nodeVal));
        TreeNode root = dfsDeserialize(node);
        return root;
    }

    //先序遍历，遇到空节点保存为None。节点值之间采用","分隔
    public void dfsSerialize(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("None,");
            return;
        } else {
            result.append(root.val+",");
            dfsSerialize(root.left, result);
            dfsSerialize(root.right, result);
        }
    }

    //采用先序遍历方式反序列化
    public TreeNode dfsDeserialize(List<String> node) {
        //遇到None则遇到空节点，返回null
        if (node.get(0).equals("None")) {
            node.remove(0);
            return null;
        } else {
            //构造根节点
            int value = Integer.parseInt(node.get(0));
            node.remove(0);
            TreeNode root = new TreeNode(value);
            //构造左子树
            root.left = dfsDeserialize(node);
            //构造右子树
            root.right = dfsDeserialize(node);
            return root;
        }
    }
}