package Leetcode.Offer;

import Leetcode.ListNode;

public class O24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode pre = null;
        while (next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }
}
