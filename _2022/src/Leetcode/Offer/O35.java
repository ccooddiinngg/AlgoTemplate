package Leetcode.Offer;

import java.util.HashMap;
import java.util.Map;

public class O35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node dummy = new Node(0);
        Node p = dummy;
        while (curr != null) {
            p.next = map.get(curr);
            p.next.random = map.get(curr.random);
            p = p.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
