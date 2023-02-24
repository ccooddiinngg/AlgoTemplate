package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int step = len / 2;
        ListNode c2 = head;
        while (step > 0) {
            c2 = c2.next;
            step--;
        }

        ListNode next = c2.next;
        ListNode pre = null;
        while (next != null) {
            c2.next = pre;
            pre = c2;
            c2 = next;
            next = next.next;
        }
        c2.next = pre;

        ListNode c1 = head.next;
        curr = head;
        boolean select1 = false;
        while (curr != null) {
            if (select1) {
                curr.next = c1;
                curr = c1;
                c1 = c1 == null ? c1:c1.next;
            }else {
                curr.next = c2;
                curr = c2;
                c2 = c2 == null ? c2:c2.next;
            }
            select1 = !select1;
        }
    }
}
