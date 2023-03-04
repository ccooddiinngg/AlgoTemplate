package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode h2 = reverse(right);
        ListNode h1 = head;
        ListNode p = h1;
        h1 = h1.next;
        boolean b = true;
        while (h1 != null || h2 != null) {
            if (b) {
                p.next = h2;
                h2 = h2.next;
            } else {
                p.next = h1;
                h1 = h1.next;
            }
            p = p.next;
            b = !b;
        }
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

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 5};
        Linked_List linked_list = new Linked_List(nums);
        reorderList(linked_list.head);
        Assertions.assertArrayEquals(new int[]{1, 5, 2, 4, 3}, linked_list.toArray());
    }
}

