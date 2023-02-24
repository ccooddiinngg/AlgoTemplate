package Leetcode.ACW_LeetCode;

import Leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> p = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                p.add(lists[i]);
        }
        int min = 0;
        while (min != -1) {
            min = -1;
            for (int i = 0; i < p.size(); i++) {
                if (min == -1 || p.get(i).val < p.get(min).val) {
                    min = i;
                }
            }
            if (min != -1) {
                curr.next = p.get(min);
                if (p.get(min).next == null) {
                    p.remove(min);
                } else {
                    p.set(min, p.get(min).next);
                }
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
