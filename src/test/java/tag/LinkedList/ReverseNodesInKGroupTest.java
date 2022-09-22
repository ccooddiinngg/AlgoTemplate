package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.SinglyLinkedList;
import utils.ListNode;

class ReverseNodesInKGroupTest {
    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(nums);
        ListNode res = reverseNodesInKGroup.reverseKGroup(singlyLinkedList.head, k);
        Assertions.assertArrayEquals(new int[]{3, 2, 1, 4, 5}, res.print());
    }

}