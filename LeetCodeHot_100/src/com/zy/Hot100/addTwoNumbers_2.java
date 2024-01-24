package com.zy.Hot100;

import com.zy.structure.ListNode;
/*
* 2、两数相加，数的数位用链表保存，链表
* */
public class addTwoNumbers_2 {
    public static void main(String[] args) {

    }
}

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l3 = result;
        int c = 0;// 表示进位
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b + c;
            if (sum >= 10) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            l3.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null || l2 != null || c != 0) {
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                int a = l2.val;
                int sum = a + c;
                if (sum >= 10) {
                    c = 1;
                    sum -= 10;
                } else {
                    c = 0;
                }
                l3.val = sum;
                l2 = l2.next;
                if(l2 != null || c != 0) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }
            }
        }
        if (l1 != null && l2 == null) {
            while (l1 != null) {
                int a = l1.val;
                int sum = a + c;
                if (sum >= 10) {
                    c = 1;
                    sum -= 10;
                } else {
                    c = 0;
                }
                l3.val = sum;
                l1 = l1.next;
                if(l1 != null || c != 0) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }
            }
        }
        if (l1 == null && l2 == null) {
            if (c != 0) {
                l3.val = c;
            }
            return result;
        }
        return null;
    }
}