package Leetcode.MostLiked100;

import Leetcode.ListNode;

public class ReverseNodesInKGroup {

//     public ListNode reverseKGroup(ListNode head, int k) {
//         Stack<ListNode> stack = new Stack<>();
//         ListNode dummy = new ListNode(0);

//         int len = 0;
//         ListNode curr = head;
//         while (curr != null) {
//             len++;
//             curr = curr.next;
//         }
//         int steps = len / k;

//         ListNode pre = dummy;
//         curr = head;
//         for (int s = 0; s < steps; s++) {
//             for (int i = 0; i < k; i++) {
//                 stack.push(curr);
//                 curr = curr.next;
//             }

//             while (!stack.isEmpty()) {
//                 pre.next = stack.pop();
//                 pre = pre.next;
//             }
//         }
//         pre.next = curr;
//         return dummy.next;
//     }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int step = 0;
        while (curr != null && step < k) {
            curr = curr.next;
            step++;
        }
        if (step < k) return head;

        ListNode p = reverseKGroup(curr, k);
        ListNode c = head;
        ListNode n = head.next;

        while (step > 0) {
            c.next = p;
            p = c;
            c = n;
            n = n == null ? n : n.next;
            step--;
        }
        return p;
    }

    
}
