package Leetcode.Offer;

import Leetcode.ListNode;

public class O06 {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int[] arr = new int[len];
        helper(head, len - 1, arr);
        return arr;
    }

    void helper(ListNode head, int idx, int[] arr) {
        if (head == null) {
            return;
        }
        helper(head.next, idx - 1, arr);
        arr[idx] = head.val;
    }
}
