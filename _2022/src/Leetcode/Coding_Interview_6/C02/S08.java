package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S08 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        //init fast 2 steps and slow 1 step
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
