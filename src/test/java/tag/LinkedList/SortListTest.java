package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.SinglyLinkedList;

class SortListTest {
    SortList sortList = new SortList();

    @Test
    void test() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(new int[]{4, 2, 1, 3});
        SinglyLinkedList res = new SinglyLinkedList(sortList.sortList(singlyLinkedList.head));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, res.print());
    }

}