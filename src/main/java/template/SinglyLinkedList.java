package template;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {
    public ListNode head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(ListNode head) {
        this.head = head;
    }

    public SinglyLinkedList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        this.head = dummy.next;
    }

    public void insert(int v) {
        ListNode node = new ListNode(v);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode p = this.head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    public int[] print() {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public void reverse() {
        if (this.head == null || this.head.next == null) {
            return;
        }
        ListNode pre = null;
        ListNode p = this.head;
        ListNode next = this.head.next;
        while (next != null) {
            p.next = pre;
            pre = p;
            p = next;
            next = next.next;
        }
        p.next = pre;
        this.head = p;
    }
}
