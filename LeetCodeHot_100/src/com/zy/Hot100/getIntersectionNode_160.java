package com.zy.Hot100;

import com.zy.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
160. 相交链表
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。
自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
* */
public class getIntersectionNode_160 {
    public static void main(String[] args) {

    }
}

class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1、集合去重
        Set<ListNode> set = new HashSet<>();
        ListNode node1 = headA;
        ListNode node2 = headB;
        ListNode ans1 = null;
        while (node1 != null) {
            set.add(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            if (!set.contains(node2)) {
                set.add(node2);
                node2 = node2.next;
            } else {
                ans1 = node2;
                break;
            }
        }

        //2、双指针:
        //1) list1与list2同时遍历，如果两个链表长度相同，则两个指针相遇处就是交叉节点
        //2) 如果链表长度不同，list1：m,list2：n，相同部分长度为c,不同部分分别为a，b；即a+c=m,b+c=n；
        //3) pA到链表尾时指向headB，pB到链表尾时，指向headA；继续遍历，两个指针一定相遇，此时pA走了a+c+b，pB走了b+c+a


        return ans1;
    }
}
