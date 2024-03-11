package com.zy.Hot100;

import com.zy.structure.ListNode;
/*
234. 回文链表[递归、链表操作]
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
* */
public class isPalindrome_234 {
    public static void main(String[] args) {

    }
}
class Solution_234 {
    private ListNode frontNode;
    public boolean isPalindrome(ListNode head) {
        //方法一：O(n)的时间复杂度和空间复杂度：将链表的值拷贝到数组中，然后利用双指针进行回文判断
        //方法二：O(n)的时间复杂度和空间复杂度：利用递归的进行判断，递归的压栈过程相当于链表的正向遍历，而弹栈过程相当于反向遍历
        //方法三：O(n)的时间复杂度和O(1)的空间复杂度将链表的后半部分进行翻转，然后判断两个链表是否相等
        frontNode = head;
        boolean result1 = recursion(head);
        boolean result2 = invertList(head);
        return result2;
    }

    //利用递归的特性进行回文判断,预先保存正向节点，而弹栈过程为反向遍历
    public boolean recursion(ListNode node) {
        if (node != null) {
            if (!recursion(node.next))
                return false;
            if (node.val != frontNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }

    public boolean invertList(ListNode head) {
        ListNode h = head;
        ListNode p = head;
        ListNode q = head;
        while (q.next != null) {
            p = p.next;
            q = q.next;
            if (q.next != null)
                q = q.next;
        }
        //p 指向链表中部, q指向链表尾部
        //翻转链表: 头插法
        while (p != q) {
            ListNode node = p;
            p = p.next;
            node.next = q.next;
            q.next = node;
        }
        boolean flag = true;
        //比较两个链表
        while (q != null) {
            if (q.val != h.val)
                flag = false;
            q = q.next;
            h = h.next;
        }
        return flag;

    }



}