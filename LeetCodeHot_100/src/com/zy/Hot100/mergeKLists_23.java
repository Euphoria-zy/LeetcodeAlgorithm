package com.zy.Hot100;

import com.zy.structure.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
* 23. 合并 K 个升序链表:优先队列
* 给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表
* */
public class mergeKLists_23 {
    public static void main(String[] args) {

    }
}

class Solution_23 {
    //使用优先队列的方法
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < lists.length; i++) {
            //添加头结点非空节点
            if (lists[i] != null)
                priorityQueue.offer(lists[i]);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            //节点非空时添加
            if (poll.next != null)
                priorityQueue.offer(poll.next);
            p = p.next;
        }
        return head.next;
    }

    //使用分治策略
    public ListNode merge(ListNode[] lists, int left, int right) {
        //递归出口,一个链表不需要合并
        if (left == right) {
            return lists[left];
        } else if (left > right) {
            return null;
        } else {
            int middle = (left + right) / 2;
            //递归
            return mergeTwoList(merge(lists, left, middle), merge(lists, middle+1, right));
        }
    }
    //合并两个链表
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
            while (l1 != null && l2 != null && l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l1 != null && l2 == null) {
            p.next = l1;
        }
        if (l1 == null && l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}