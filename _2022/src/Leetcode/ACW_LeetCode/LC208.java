package Leetcode.ACW_LeetCode;

public class LC208 {
    class Trie {

        class Node {
            Node[] next;
            boolean isEnd;

            public Node() {
                next = new Node[26];
                isEnd = false;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }


        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Node();
                }
                curr = curr.next[idx];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node node = starts(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return starts(prefix) != null;
        }

        Node starts(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (curr.next[idx] == null) return null;
                curr = curr.next[idx];
            }
            return curr;
        }
    }
}
