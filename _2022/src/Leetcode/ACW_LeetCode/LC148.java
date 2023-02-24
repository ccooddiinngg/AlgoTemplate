package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

public class LC148 {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return sort(head, len);
    }

    ListNode sort(ListNode left, int len) {
        if (len == 1) return left;
        ListNode p = left;
        int mid = len / 2;
        int step = mid - 1;
        while (step > 0) {
            p = p.next;
            step--;
        }
        ListNode right = p.next;
        p.next = null;
        ListNode h1 = sort(left, mid);
        ListNode h2 = sort(right, len - mid);
        return merge(h1, h2);
    }

    ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                curr.next = h1;
                h1 = h1.next;
            }else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        while (h1 != null) {
            curr.next = h1;
            h1 = h1.next;
            curr = curr.next;
        }
        while (h2 != null) {
            curr.next = h2;
            h2 = h2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
