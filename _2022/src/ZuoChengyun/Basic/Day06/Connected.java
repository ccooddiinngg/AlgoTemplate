package ZuoChengyun.Basic.Day06;

import ZuoChengyun.Basic.Day02.ZLinkedList;
import ZuoChengyun.Basic.Day02.ZListNode;
import org.junit.jupiter.api.Test;

public class Connected {

    //return circle ? first node entering the circle : null
    public ZListNode isCircle(ZListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ZListNode fast = head.next.next;
        ZListNode slow = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //no loop
    public ZListNode firstMeet(ZListNode head1, ZListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ZListNode curr1 = head1;
        int count = 0;
        while (curr1.next != null) {
            count++;
            curr1 = curr1.next;
        }
        ZListNode curr2 = head2;
        while (curr2.next != null) {
            count--;
            curr2 = curr2.next;
        }

        if (curr1 != curr2) {
            return null;
        }
        //is connected
        if (count >= 0) {
            curr1 = head1;
            curr2 = head2;
        } else {
            curr1 = head2;
            curr2 = head1;
            count = -count;
        }

        while (count > 0) {
            curr1 = curr1.next;
            count--;
        }
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1;
    }

    @Test
    void test1() {
        ZListNode n0 = new ZListNode(0);
        ZListNode n1 = new ZListNode(1);
        ZListNode n2 = new ZListNode(2);
        ZListNode n3 = new ZListNode(3);
        ZListNode n4 = new ZListNode(4);
        ZLinkedList list1 = new ZLinkedList();
        list1.insert(n0);
        list1.insert(n1);
        list1.insert(n2);
        ZLinkedList list2 = new ZLinkedList();
        list2.insert(n3);
        list2.insert(n0);

        ZListNode connected = firstMeet(list1.head, list2.head);
        System.out.println(connected.val);

        ZListNode n10 = new ZListNode(0);
        ZListNode n11 = new ZListNode(1);
        ZListNode n12 = new ZListNode(2);
        ZListNode n13 = new ZListNode(3);
        ZListNode n14 = new ZListNode(4);
        ZListNode n15 = new ZListNode(5);
        ZListNode n16 = new ZListNode(6);
        ZLinkedList list3 = new ZLinkedList();
        list3.insert(n10);
        list3.insert(n11);
        list3.insert(n12);
        list3.insert(n13);
        list3.insert(n14);
        list3.insert(n15);
        list3.insert(n16);
        n16.next = n14;

        ZListNode circle = isCircle(list3.head);
        System.out.println(circle == null ? "null" : circle.val);

    }


}
