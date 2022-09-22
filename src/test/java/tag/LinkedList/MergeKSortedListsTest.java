package tag.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.SinglyLinkedList;
import utils.ListNode;

class MergeKSortedListsTest {
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

    @Test
    void test() {
        int[][] nums = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] list = new ListNode[nums.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new SinglyLinkedList(nums[i]).head;
        }
        ListNode res = mergeKSortedLists.mergeKLists(list);
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6}, res.print());
    }

}