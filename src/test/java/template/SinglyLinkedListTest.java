package template;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    @BeforeAll
    static void setup() {

    }

    @Test
    void test() {
        singlyLinkedList.insert(1);
        assertArrayEquals(new int[]{1}, singlyLinkedList.print());
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(4);
        singlyLinkedList.insert(3);
        assertArrayEquals(new int[]{1, 2, 4, 3}, singlyLinkedList.print());
    }

    @Test
    void reverse() {
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(3);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(4);
        singlyLinkedList.reverse();
        assertArrayEquals(new int[]{4, 2, 3, 1}, singlyLinkedList.print());
    }

}