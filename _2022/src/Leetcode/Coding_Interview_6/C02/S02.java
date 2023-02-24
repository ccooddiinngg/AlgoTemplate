package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S02 {
    public int kthToLast(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = head;
        while (len > k) {
            curr = curr.next;
            len--;
        }
        return curr.val;
    }
}
