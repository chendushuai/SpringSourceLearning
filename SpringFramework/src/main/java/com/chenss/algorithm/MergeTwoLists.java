package com.chenss.algorithm;

/**
 * @author chenss002
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (null != l1 && null != l2) {
            if (l1.val<l2.val) {
                curr.next=l1;
                l1=l1.next;
            } else {
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if (null == l1) {
            curr.next=l2;
        } else if (null ==l2) {
            curr.next=l1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        MergeTwoLists lis = new MergeTwoLists();
        ListNode listNode = lis.mergeTwoLists(l1,l2);
        while (null != listNode.next) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
