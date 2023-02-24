package Leetcode.Offer;

import Leetcode.ListNode;

public class O18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
