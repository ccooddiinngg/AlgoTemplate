package Playground.Trie;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) {
                p.next[idx] = new Node();
            }
            p = p.next[idx];
        }
        p.isEnd = true;
    }

    public boolean contains(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) return false;
            p = p.next[idx];
        }
        return p.isEnd;
    }

    public boolean prefix(String pre) {
        Node p = root;
        for (int i = 0; i < pre.length(); i++) {
            int idx = pre.charAt(i) - 'a';
            if (p.next[idx] == null) return false;
            p = p.next[idx];
        }
        return true;
    }


    class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
            isEnd = false;
        }
    }
}
