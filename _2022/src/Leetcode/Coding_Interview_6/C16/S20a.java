package Leetcode.Coding_Interview_6.C16;

import java.util.ArrayList;
import java.util.List;

public class S20a {
    public List<String> getValidT9Words(String num, String[] words) {
        for (String s : words) {
            insert(s);
        }
        return find(num);
    }

    Node root = new Node();
    char[] map = "22233344455566677778889999".toCharArray();

    class Node {
        Node[] next;
        List<String> strs;

        public Node() {
            next = new Node[10];
            strs = new ArrayList<>();
        }
    }

    void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = map[s.charAt(i) - 'a'] - '0';
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
        curr.strs.add(s);
    }

    List<String> find(String s) {
        List<String> list = new ArrayList<>();
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            if (curr.next[idx] == null) {
                return list;
            }
            curr = curr.next[idx];
        }
        return curr.strs;
    }
}
