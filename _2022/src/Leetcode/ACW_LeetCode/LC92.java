package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode curr = head;
        int count = 0;
        while (count < right) {
            curr = curr.next;
            count++;
        }
        ListNode pre = curr;

        curr = head;
        count = 0;
        while (count < left - 1) {
            curr = curr.next;
            count++;
        }

        ListNode next = curr.next;
        count = 0;
        while (count < right - left) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
            count++;
        }
        curr.next = pre;
        ListNode newHead = curr;
        if (left == 1) return newHead;
        curr = head;
        count = 0;
        while (count < left - 2) {
            curr = curr.next;
            count++;
        }
        curr.next = newHead;
        return head;
    }
}
