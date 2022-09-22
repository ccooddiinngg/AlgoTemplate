package tag.LinkedList;

import utils.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return sort(head, len);
    }

    ListNode sort(ListNode head, int len) {
        if (len <= 1) {
            return head;
        }
        ListNode p = head;
        int k = len / 2;
        while (k > 1) {
            p = p.next;
            k--;
        }
        ListNode next = p.next;
        p.next = null;
        ListNode left = sort(head, len / 2);
        ListNode right = sort(next, len - len / 2);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null) p.next = left;
        if (right != null) p.next = right;
        return dummy.next;
    }
}
