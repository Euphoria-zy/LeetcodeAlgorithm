package com.zy.normalproblem;

import java.util.*;

public class smallestStringWithSwaps_Medium
{
    public static void main(String[] args)
    {
        String s = "udyyek";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(3);item.add(3);
        pairs.add(new ArrayList<>(item));
        item.clear();item.add(3);item.add(0);
        pairs.add(new ArrayList<>(item));
        item.clear();item.add(5);item.add(1);
        pairs.add(new ArrayList<>(item));
        item.clear();item.add(3);item.add(1);
        pairs.add(new ArrayList<>(item));
        item.clear();item.add(3);item.add(4);
        pairs.add(new ArrayList<>(item));
        item.clear();item.add(3);item.add(5);
        pairs.add(new ArrayList<>(item));
        String result = Solution_42.smallestStringWithSwaps(s, pairs);
        System.out.println(result);

    }
}
class Solution_42
{
    //交换具有传递性，比如[1,2],[2,3]可交换，则1,2,3可任意交换，对于同一个连通分量的字符串，按ASll排序后，即得到字典序最小的序列。采用并查集寻找连通分量
    public static int[] parent;
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs)
    {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < pairs.size(); i++) {
            int first = pairs.get(i).get(0);
            int second = pairs.get(i).get(1);
            union(first, second);
        }
        //将同一连通分量的字符存入HashTable
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if (!hashMap.containsKey(root)) {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(s.charAt(i));
                hashMap.put(root, queue);
            } else {
                hashMap.get(root).add(s.charAt(i));
            }
        }

        //重组字符串
        String result = "";
        for (int i = 0; i < n; i++)
        {
            int root = find(i);
            result = result + hashMap.get(root).poll();
        }

        return result;
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY)
            return;
        else {
            parent[parentX] = parentY;
        }
    }

    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}