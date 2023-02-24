package Leetcode.Coding_Interview_6.C17;

import java.util.Arrays;

public class S15a {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        for (String str : words) {
            insert(str);
        }

        String ans = "";
        for (String str : words) {
            remove(str);
            if (find(str, 0)) {
                ans = str;
                break;
            }
            insert(str);
        }
        return ans;
    }

    boolean find(String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        Node curr = root;
        for (int i = idx; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.next[index] == null) {
                break;
            }
            if (curr.next[index].isEnd) {
                if (find(word, i + 1)) {
                    return true;
                }
            }
            curr = curr.next[index];
        }
        return false;
    }

    Node root = new Node();

    class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
            isEnd = false;
        }
    }

    void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
        curr.isEnd = true;
    }

    void remove(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            curr = curr.next[idx];
        }
        curr.isEnd = false;
    }
}
