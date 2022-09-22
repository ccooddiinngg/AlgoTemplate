package utils;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public int[] print() {
        List<Integer> list = new ArrayList<>();
        ListNode p = this;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
}

