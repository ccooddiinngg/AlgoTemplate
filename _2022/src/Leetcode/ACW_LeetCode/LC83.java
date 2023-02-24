package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode p = curr.next;
            while (p != null && p.val == curr.val) p = p.next;
            curr.next = p;
            curr = p;
        }
        return head;
    }
}
