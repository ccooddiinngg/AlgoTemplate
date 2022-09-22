package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ListNode;

class LinkedListCycleIITest {
    LinkedListCycleII linkedListCycleII = new LinkedListCycleII();

    @Test
    void test() {
        ListNode n0 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        ListNode res = linkedListCycleII.detectCycle(n0);
        Assertions.assertEquals(n1, res);
    }

}