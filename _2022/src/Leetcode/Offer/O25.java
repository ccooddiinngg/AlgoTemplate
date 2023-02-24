package Leetcode.Offer;

import Leetcode.ListNode;

public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
