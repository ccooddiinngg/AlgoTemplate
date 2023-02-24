package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null && p2 == null) return null;
            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
        }
        return p1;
    }
}
