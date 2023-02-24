package Leetcode.Offer;

import Leetcode.ListNode;

public class O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
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
        return curr;
    }
}
