package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = head;
        ListNode curr = pre.next;
        while (curr != null) {
            if (curr.val >= pre.val) {
                pre = curr;
                curr = curr.next;
            }else {
                ListNode t = dummy;
                while (t.next.val <= curr.val) {
                    t = t.next;
                }
                pre.next = curr.next;
                curr.next = t.next;
                t.next = curr;
                curr = pre.next;
            }
        }
        return dummy.next;
    }
}
