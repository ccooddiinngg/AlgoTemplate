package Leetcode.ACW_LeetCode;


import Leetcode.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = dummy;
        while (len > n) {
            curr = curr.next;
            len--;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
