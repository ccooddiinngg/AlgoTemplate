package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.SinglyLinkedList;
import utils.ListNode;

class ReverseLinkedListIITest {
    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

    @Test
    void test() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 4;
        ListNode res = reverseLinkedListII.reverseBetween(singlyLinkedList.head, left, right);
        Assertions.assertArrayEquals(new int[]{1, 4, 3, 2, 5}, res.print());
    }

}