package com.zy.Hot100;

import com.sun.scenario.effect.Merge;
import com.zy.structure.ListNode;
/*
148. 排序链表[归并排序]
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
* */
public class sortList_148 {
    public static void main(String[] args) {

    }
}

class Solution_148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    //分治
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return null;
        if (head.next == tail) {
            head.next = null;//去除重复的mid
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail)
                fast = fast.next;
        }
        ListNode mid = slow;
        ListNode listNode1 = sortList(head, mid);
        ListNode listNode2 = sortList(mid, tail);//mid重复
        return MergeList(listNode1, listNode2);
    }

    //合并两个链表
    public ListNode MergeList(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode temp = node;
        ListNode head1 = list1;
        ListNode head2 = list2;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return node.next;
    }
}