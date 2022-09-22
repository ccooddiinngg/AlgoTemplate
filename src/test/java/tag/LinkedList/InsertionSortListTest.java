package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.SinglyLinkedList;
import utils.ListNode;

class InsertionSortListTest {
    InsertionSortList insertionSortList = new InsertionSortList();

    @Test
    void test() {
        int[] nums = {4, 2, 1, 3};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(nums);
        ListNode res = insertionSortList.insertionSortList(singlyLinkedList.head);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, res.print());
    }

}