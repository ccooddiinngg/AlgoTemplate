package ZuoChengyun.Basic.Day06;

import ZuoChengyun.Basic.Day02.ZLinkedList;
import ZuoChengyun.Basic.Day02.ZListNode;
import org.junit.jupiter.api.Test;

public class FindMiddle {
    //list has odd node? return mid : return mid -1
    public ZListNode find1(ZListNode head) {
        if (head == null) return null;
        ZListNode fast = head;
        ZListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //list has odd node? return mid : return mid + 1
    public ZListNode find2(ZListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ZListNode fast = head;
        ZListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    void test1() {
        ZLinkedList list = new ZLinkedList(3);
        list.insert(1);
        list.insert(2);
        list.insert(5);
        list.insert(4);
        list.print();

        System.out.println(find2(list.head).val);
    }


}
