package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "->";
    }

    int[] toArray() {
        List<Integer> list = new ArrayList<>();
        ListNode p = this;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
