package com.chenss.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNodes {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;

        int addIndex = 0;
        int val1 = null == node1 ? 0 : node1.val;
        int val2 = null == node2 ? 0 : node2.val;
        int val = val1 + val2;
        if (val / 10 > 0) {
            addIndex = val / 10;
            val = val % 10;
        }
        List<ListNode> resultList = new ArrayList<>();
        resultList.add(new ListNode(val));
        while ((null != node1 && null != node1.next) || (null != node2 && null != node2.next)) {
            node1 = null != node1 ? node1.next : node1;
            node2 = null != node2 ? node2.next : node2;
            val1 = null == node1 ? 0 : node1.val;
            val2 = null == node2 ? 0 : node2.val;
            val = val1 + val2 + addIndex;
            if (val / 10 > 0) {
                addIndex = val / 10;
                val = val % 10;
            } else {
                addIndex = 0;
            }
            resultList.add(new ListNode(val));
        }
        if (addIndex > 0) {
            resultList.add(new ListNode(addIndex));
        }
        for (int i = resultList.size() - 2; i >= 0; i--) {
            resultList.get(i).next = resultList.get(i + 1);
        }
        return resultList.get(0);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(7);

        AddTwoNodes addTwoNodes = new AddTwoNodes();
        ListNode node = addTwoNodes.addTwoNumbers(l1, l2);

        System.out.println(node.val);
        while (null != node.next) {
            node = node.next;
            System.out.println(node.val);
        }
    }
}
