package com.zy.Hot100;

import com.zy.structure.ListNode;

/*
206. 反转链表
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
* */
public class reverseList_206 {
    public static void main(String[] args) {

    }
}

class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        //头插法,将头部节点移动到尾部
        while (head != tail) {
            ListNode node = head;
            head = head.next;
            node.next = tail.next;
            tail.next = node;
        }
        return tail;
    }
}