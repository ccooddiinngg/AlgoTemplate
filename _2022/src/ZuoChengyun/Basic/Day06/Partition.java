package ZuoChengyun.Basic.Day06;

import ZuoChengyun.Basic.Day02.ZLinkedList;
import ZuoChengyun.Basic.Day02.ZListNode;
import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class Partition {
    public ZListNode partition(ZListNode head, int num) {
        if (head == null) {
            return null;
        }

        ZListNode smallHead = null, smallTail = null, equalHead = null, equalTail = null, bigHead = null, bigTail = null;
        ZListNode curr = head;

        while (curr != null) {
            ZListNode next = curr.next;
            curr.next = null;
            if (curr.val < num) {
                if (smallHead == null) {
                    smallHead = curr;
                } else {
                    smallTail.next = curr;
                }
                smallTail = curr;
            } else if (curr.val == num) {
                if (equalHead == null) {
                    equalHead = curr;
                } else {
                    equalTail.next = curr;
                }
                equalTail = curr;
            } else {
                if (bigHead == null) {
                    bigHead = curr;
                } else {
                    bigTail.next = curr;
                }
                bigTail = curr;
            }
            curr = next;
        }
        if (smallHead == null) {
            if (equalHead == null) {
                return bigHead;
            } else {
                equalTail.next = bigHead;
                return equalHead;
            }
        } else {
            if (equalHead == null) {
                smallTail.next = bigHead;
            } else {
                smallTail.next = equalHead;
                equalTail.next = bigHead;
            }
            return smallHead;
        }

    }

    @Test
    void test1() {
        ZLinkedList list = Utils.getLinkedList(10);

        list.head = partition(list.head, 5);
        list.print();
    }


}
