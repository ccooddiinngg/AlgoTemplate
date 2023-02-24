package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S04 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode tail = curr;
        ListNode end = curr;
        curr = dummy;
        while (curr != null && curr.next != null && curr.next != end) {
            if (curr.next.val >= x) {
                ListNode t = curr.next;
                curr.next = curr.next.next;
                tail.next = t;
                t.next = null;
                tail = t;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
