package template;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {
    public ListNode head;

    public SinglyLinkedList() {
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

    public List<Integer> print() {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return list;
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
