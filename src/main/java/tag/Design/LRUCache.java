package tag.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            addFirst(node);
            return;
        }
        if (map.size() == capacity) {
            Node tailPre = tail.pre;
            remove(tailPre);
            map.remove(tailPre.key);
        }
        node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.pre = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
