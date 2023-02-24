package Leetcode.ACW_LeetCode;

public class LC706 {
    class MyHashMap {
        Node[] map;

        class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                next = null;
            }
        }

        public MyHashMap() {
            map = new Node[1000];
        }

        Node find(int key) {
            int idx = hash(key);
            Node p = map[idx];
            while (p != null && p.key != key) {
                p = p.next;
            }
            return p;
        }

        int hash(int key) {
            return key % 1000;
        }

        public void put(int key, int value) {
            Node p = find(key);
            if (p == null) {
                int idx = hash(key);
                Node node = new Node(key, value);
                node.next = map[idx];
                map[idx] = node;
            } else {
                p.value = value;
            }
        }

        public int get(int key) {
            Node p = find(key);
            return p == null ? -1 : p.value;
        }

        public void remove(int key) {
            Node p = find(key);
            if (p != null) {
                p.key = -1;
            }
        }
    }
}
