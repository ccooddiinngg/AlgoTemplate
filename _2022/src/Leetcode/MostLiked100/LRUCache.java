package Leetcode.MostLiked100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int k;
        int v;
        Node pre;
        Node next;

        public Node(int key, int value) {
            k = key;
            v = value;
        }

        public Node() {
            k = 0;
            v = 0;
        }
    }

    public int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        addNode(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.v = value;
            removeNode(node);
            addNode(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                Node last = tail.pre;
                removeNode(last);
                map.remove(last.k);
            }
            addNode(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}
