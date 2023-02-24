package Leetcode.ACW_LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        Node pre = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (pre != null) pre.next = curr;
            pre = curr;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            size--;
            if (size == 0) {
                pre.next = null;
                pre = null;
                size = q.size();
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
