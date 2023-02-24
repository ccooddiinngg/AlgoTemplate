package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        if (len < k) return head;
        ListNode pre = null;
        curr = head;
        ListNode next = curr.next;
        int step = k;
        while (step > 1) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
            step--;
        }
        curr.next = pre;
        head.next = reverseKGroup(next, k);
        return curr;
    }
}
