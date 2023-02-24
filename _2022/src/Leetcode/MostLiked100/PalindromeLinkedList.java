package Leetcode.MostLiked100;

import Leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int mid = len / 2;
        curr = head;

        while (mid > 0) {
            stack.push(curr.val);
            curr = curr.next;
            mid--;
        }
        if (len % 2 != 0) {
            curr = curr.next;
        }
        while (curr != null) {
            if (curr.val != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;

    }

    @Test
    void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(isPalindrome(n1));
    }
}
