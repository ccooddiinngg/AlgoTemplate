package tag.LinkedList;

import utils.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        int k1 = left - 1;
        while (k1 > 0) {
            p = p.next;
            k1--;
        }
        ListNode n1 = p;
        int k2 = right - left + 1;
        while (k2 > 0) {
            p = p.next;
            k2--;
        }
        ListNode n2 = p.next;
        ListNode newHead = n1.next;
        n1.next = null;
        p.next = null;
        n1.next = reverse(newHead);
        newHead.next = n2;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode next = p.next;
        while (next != null) {
            p.next = pre;
            pre = p;
            p = next;
            next = next.next;
        }
        p.next = pre;
        return p;
    }
}
