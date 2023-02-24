package Leetcode.Coding_Interview_6.C16;

import java.util.HashMap;
import java.util.Map;

public class S25 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        Node head;
        Node tail;
        int capacity;

        class Node {
            int key;
            int val;
            Node pre;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        Node find(int key) {
            return map.get(key);
        }

        Node remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }

        Node removeFirst() {
            Node node = head.next;
            return remove(node);
        }

        void addLast(Node node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.next = tail;
            node.pre.next = node;
        }

        public int get(int key) {
            Node node = find(key);
            if (node == null) return -1;
            remove(node);
            addLast(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (find(key) != null) {
                remove(find(key));
                map.remove(key);
            }
            if (map.size() == capacity) {
                Node node = removeFirst();
                map.remove(node.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            addLast(node);
        }
    }
}
