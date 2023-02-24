package Leetcode.Coding_Interview_6.C02;

import Leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class S06 {
    //reverse first half
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = head;
        int step = len / 2;
        ListNode pre = null;
        ListNode next = curr.next;
        while (step > 0) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = curr.next;
            step--;
        }
        if (len % 2 == 1) {
            curr = curr.next;
        }
        while (curr != null) {
            if (curr.val != pre.val) {
                return false;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return true;
    }

    //reverse LinkedList
    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }

    //ArrayList cache val
    public static boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        System.out.println(list);
        for (int i = 0; i <= (list.size() - 1) / 2; i++) {
            //compare Integer using .intValue()
            if (list.get(i).intValue() != list.get(list.size() - 1 - i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
