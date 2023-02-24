package ZuoChengyun.Basic.Day06;

import ZuoChengyun.Basic.Day02.ZLinkedList;
import ZuoChengyun.Basic.Day02.ZListNode;
import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;


public class IsPalindrome {
    // 1->2->3->2->1->null : ture
    public boolean isPalindrome(ZListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ZListNode slow = head;
        ZListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ZListNode tail = reverse(slow);

        ZListNode left = head;
        ZListNode right = tail;
        boolean res = true;
        while (left != slow) {
            if (left.val != right.val) {
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        reverse(tail);
        return res;
    }

    private ZListNode reverse(ZListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ZListNode p = node;
        ZListNode pre = null;
        ZListNode next = p.next;
        while (next != null) {
            p.next = pre;
            pre = p;
            p = next;
            next = next.next;
        }
        p.next = pre;
        return p;
    }

    @Test
    void test2() {
        ZLinkedList list = Utils.getLinkedList(5);

        boolean isPal = isPalindrome(list.head);
        System.out.println(isPal);
        list.print();
    }


}
