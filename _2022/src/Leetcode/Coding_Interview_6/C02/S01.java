package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class S01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        set.add(curr.val);
        while (curr != null && curr.next != null) {
            if (!set.contains(curr.next.val)) {
                set.add(curr.next.val);
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}
