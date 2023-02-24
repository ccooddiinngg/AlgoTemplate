package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode next = head.next.next;
        newHead.next = head;
        head.next = swapPairs(next);
        return newHead;
    }
}
