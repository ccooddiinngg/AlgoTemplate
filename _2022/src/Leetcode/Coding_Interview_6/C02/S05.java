package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode c0 = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        int a = 0;
        int b = 0;
        while (c1 != null || c2 != null) {
            a = c1 != null ? c1.val : 0;
            b = c2 != null ? c2.val : 0;
            int sum = a + b + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            c0.next = node;
            c0 = node;
            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }
        if (carry != 0) {
            c0.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
