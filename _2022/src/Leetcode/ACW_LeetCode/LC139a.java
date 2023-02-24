package Leetcode.ACW_LeetCode;

import java.util.List;

public class LC139a {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict) {
            insert(word);
        }
        return bt(s, 0, new int[s.length()]);
    }

    boolean bt(String s, int idx, int[] cache) {
        if (idx == s.length()) return true;
        if (cache[idx] != 0) return cache[idx] == 1;
        Node p = root;
        for (int i = idx; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (p.next[index] == null) {
                break;
            }
            p = p.next[index];
            if (p.isEnd) {
                if (bt(s, i + 1, cache)) {
                    cache[idx] = 1;
                    return true;
                }
            }
        }
        cache[idx] = 2;
        return false;
    }

    Node root = new Node();

    void insert(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) p.next[idx] = new Node();
            p = p.next[idx];
        }
        p.isEnd = true;
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
