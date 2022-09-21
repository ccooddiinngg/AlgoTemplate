package tag.LinkedList;

import utils.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + r >> 1;
        ListNode node1 = mergeKLists(lists, l, mid);
        ListNode node2 = mergeKLists(lists, mid + 1, r);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return dummy.next;
    }
}
