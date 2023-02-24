package ZuoChengyun.Basic.Day06;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Clone {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

    }

    public void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " => ");
            curr = curr.next;
        }
        System.out.println();
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                System.out.print("null => ");
            } else {
                System.out.print(curr.random.val + " => ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    //with hashmap
    public Node clone1(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    //without hashmap
    public Node clone2(Node head) {
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            Node next = curr.next.next;
            curr.next = next;
            newCurr.next = next == null ? null : next.next;
            curr = next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    @Test
    void test1() {
        Node n0 = new Node(3);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(4);
        n0.next = n1;
        n0.random = n1;
        n1.next = n2;
        n1.random = n3;
        n2.next = n3;
        n2.random = null;
        n3.next = n4;
        n3.random = n1;
        n4.next = null;
        n4.random = n2;
        print(n0);

        Node newHead = clone2(n0);
        print(newHead);
    }
}
