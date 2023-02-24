package Leetcode.ACW_LeetCode;

public class LC421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            insert(num);
            Node p = root;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i & 1);
                if (p.next[1 - bit] != null) {
                    res += 1 << i;
                    p = p.next[1 - bit];
                } else {
                    p = p.next[bit];
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }

    Node root = new Node();

    class Node {
        Node[] next;

        public Node() {
            next = new Node[2];
        }
    }

    void insert(int num) {
        Node p = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i & 1);
            if (p.next[bit] == null) {
                p.next[bit] = new Node();
            }
            p = p.next[bit];
        }
    }
}
