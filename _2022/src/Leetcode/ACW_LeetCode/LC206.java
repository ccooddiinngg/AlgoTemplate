package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC206 {
    ListNode h;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = bt(head);
        node.next = null;
        return h;
    }

    ListNode bt(ListNode node) {
        if (node.next == null) {
            h = node;
            return node;
        }
        ListNode next = bt(node.next);
        next.next = node;
        return node;
    }
}
