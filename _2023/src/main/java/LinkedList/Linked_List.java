package LinkedList;

public class Linked_List {
    ListNode head;

    public Linked_List(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        head = dummy.next;
    }

    int[] toArray() {
        return head.toArray();
    }

}
