package Leetcode.ACW_LeetCode;


import Leetcode.ListNode;

public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode c = dummy;
        ListNode c1 = list1;
        ListNode c2 = list2;
        while (c1 != null || c2 != null) {
            int n1 = c1 != null ? c1.val : Integer.MAX_VALUE;
            int n2 = c2 != null ? c2.val : Integer.MAX_VALUE;
            if (n1 < n2) {
                c.next = c1;
                if (c1 != null) c1 = c1.next;
            } else {
                c.next = c2;
                if (c2 != null) c2 = c2.next;
            }
            c = c.next;
        }
        return dummy.next;
    }
}
