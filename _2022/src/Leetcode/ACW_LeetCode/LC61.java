package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int k1 = k % len;
        if (k1 == 0) return head;
        curr = head;
        int step = len - k1 - 1;
        while (step > 0) {
            curr = curr.next;
            step--;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }
}
