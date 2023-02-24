package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode c1 = headA;
        ListNode c2 = headB;
        int l1 = 0;
        int l2 = 0;
        while (c1 != null) {
            c1 = c1.next;
            l1++;
        }
        while (c2 != null) {
            c2 = c2.next;
            l2++;
        }
        c1 = headA;
        c2 = headB;
        int delta = 0;
        if (l1 > l2) {
            delta = l1 - l2;
            while (delta > 0) {
                c1 = c1.next;
                delta--;
            }
        } else {
            delta = l2 - l1;
            while (delta > 0) {
                c2 = c2.next;
                delta--;
            }
        }
        while (c1 != null && c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }
}
