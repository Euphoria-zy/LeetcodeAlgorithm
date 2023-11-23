package com.zy.DepthFirstSearch;

/*
 * code for class lockingTree_Medium
 * @param null
 * @Description
    1993. 树上的操作 【bfs, dfs】
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/26 15:31
 **/
import java.util.*;

public class lockingTree_Medium
{
    public static void main(String[] args)
    {
        int[] parent = new int[] {
                -1, 0, 0, 1, 1, 2, 2
        };
        LockingTree lockingTree = new LockingTree(parent);

    }
}

class LockingTree {
    private Map<Integer, Integer> lock = new HashMap<>();
    private Map<Integer, Integer> childToParent = new HashMap<>();
    private Map<Integer, Set<Integer>> parentToChild = new HashMap<>();
    private boolean parentIsLock = false;
    private boolean childIsLock = false;
    private Queue<Integer> queue;
    public LockingTree(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            childToParent.put(i, parent[i]);
            if (!parentToChild.containsKey(parent[i])) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                parentToChild.put(parent[i], set);
            } else {
                Set<Integer> temp = parentToChild.get(parent[i]);
                temp.add(i);
                parentToChild.put(parent[i], temp);
            }
        }
    }

    public boolean lock(int num, int user) {
        if(!lock.containsKey(num)) {
            lock.put(num, user);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lock.containsKey(num)) {
            if (lock.get(num) == user) {
                lock.remove(num);
                return true;
            } else
                return false;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (!lock.containsKey(num)) {   //未上锁
            //判断num父节点有没有加锁
            find(num);
            if (!parentIsLock) {
                //找到num结点加锁的子节点进行解锁,且对num结点加锁
                bfs(num);
                if (childIsLock) {
                    lock.put(num, user);
                    parentIsLock = childIsLock = false;
                    return true;
                } else {
                    parentIsLock = childIsLock = false;
                    return false;
                }
            } else {
                parentIsLock = childIsLock = false;
                return false;  //父节点有锁
            }
        }
        return false;  //已上锁
    }

    public void find(int num) {
        num = childToParent.get(num);
        if(num != -1) {
            if (!lock.containsKey(num)) {
                find(num);
            }
            else {
                parentIsLock = true;
                return;
            }
        }
        return;
    }

    public void bfs(int num) {
        queue = new LinkedList<>();
        queue.add(num);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            if(parentToChild.containsKey(parent)) {
                Set<Integer> integers = parentToChild.get(parent);
                for (Integer child : integers) {
                    if (lock.containsKey(child)) {
                        lock.remove(child);
                        childIsLock = true;
                    }
                    queue.add(child);
                }
            }
        }
    }
}