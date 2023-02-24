package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LC146 {
    class LRUCache {
        Map<Integer, Node> map;
        Node h;
        Node e;
        int cap;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.cap = capacity;
            this.h = new Node();
            this.e = new Node();
            h.next = e;
            e.pre = h;
        }

        boolean isFull() {
            return map.size() == cap;
        }
        void insert(Node pre, Node node) {
            Node next = pre.next;
            pre.next = node;
            node.next = next;
            next.pre = node;
            node.pre = pre;
        }

        void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        class Node {
            int key;
            int val;
            Node pre;
            Node next;
            public Node() {

            }
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.pre = null;
                this.next = null;
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            remove(node);
            insert(h, node);
            return node.val;
        }

        public void put(int key, int value) {
            //如果有相同的key
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                remove(node);
                insert(h, node);
                return;
            }
            //先remove node，再map remove (e.pre.key) 会删除其他的node
            if (isFull()) {
                map.remove(e.pre.key);
                remove(e.pre);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insert(h, node);
        }
    }

    @Test
    void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
