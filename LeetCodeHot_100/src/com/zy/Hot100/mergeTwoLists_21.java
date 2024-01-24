package com.zy.Hot100;

import com.zy.structure.ListNode;
/*
*
21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* */
public class mergeTwoLists_21 {
    public static void main(String[] args) {

    }
}
class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1 != null && list2 != null) {
            while (list1 != null && list2 != null && list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }
            while (list2 != null && list2 != null && list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if (list1 == null && list2 != null) {
            p.next = list2;
        }
        if (list1 != null && list2 == null) {
            p.next = list1;
        }
        return head.next;
    }
}