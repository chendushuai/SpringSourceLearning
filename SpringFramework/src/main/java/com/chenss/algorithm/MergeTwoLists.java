package com.chenss.algorithm;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
