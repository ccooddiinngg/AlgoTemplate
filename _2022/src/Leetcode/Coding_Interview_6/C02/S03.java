package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

public class S03 {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        while (curr != null && curr.next != null) {
            curr.val = curr.next.val;
            if (curr.next.next == null) {
                curr.next = null;
                break;
            } else {
                curr = curr.next;
            }
        }
    }
}
