package com.chenss.algorithm;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head==null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode p = head;
        ListNode n = head.next;
        ListNode prev = swap(p, n);
        prev=prev.next;
        while (true) {
            if ((p = prev.next)== null || (n = p.next)== null) {
                break;
            }
            prev.next=swap(p,n);
            prev=prev.next.next;
        }
        return result;
    }

    public static ListNode swap(ListNode p,ListNode n) {
        ListNode temp = n.next;
        n.next = p;
        p.next = temp;
        return n;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode next = new ListNode(2);
        head1.next = next;
        next.next = new ListNode(3);
        next.next.next = new ListNode(4);
        ListNode result = swapPairs(head1);
        while (result!=null) {
            System.out.println(result.val);
            result=result.next;
        }
    }
}
