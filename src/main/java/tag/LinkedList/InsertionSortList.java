package tag.LinkedList;

import utils.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if (p2.val >= p1.val) {
                p1 = p2;
                p2 = p2.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < p2.val) {
                    p = p.next;
                }
                p1.next = p1.next.next;
                p2.next = p.next;
                p.next = p2;
                p2 = p1.next;
            }
        }
        return dummy.next;
    }

}
