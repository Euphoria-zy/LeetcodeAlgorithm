package com.zy.Hot100;

import com.zy.structure.ListNode;

/*
* 19. 删除链表的倒数第 N 个结点
* 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
* */
public class removeNthFromEnd_19 {
    public static void main(String[] args) {

    }
}

class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;
        while (count < n) {
            p3 = p3.next;
            count++;
        }
        if (p3.next == null) {
            return p2.next;
        } else {
            p2 = p2.next;
            p3 = p3.next;
            while (p3.next != null) {
                p1 = p1.next;
                p2 = p2.next;
                p3 = p3.next;
            }
            p1.next = p2.next;
            return head;
        }
    }
}