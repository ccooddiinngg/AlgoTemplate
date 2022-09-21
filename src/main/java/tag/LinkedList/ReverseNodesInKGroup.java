package tag.LinkedList;

import utils.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = head;
        ListNode p2 = head;
        while (true) {
            int len = 1;
            while (len < k && p2 != null) {
                p2 = p2.next;
                len++;
            }
            if (p2 == null) {
                p.next = p1;
                break;
            }

            ListNode nextHead = p2.next;
            p2.next = null;
            ListNode reversed = reverse(p1);
            p.next = reversed;
            p = p1;
            p1 = nextHead;
            p2 = nextHead;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        ListNode next = head.next;
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
