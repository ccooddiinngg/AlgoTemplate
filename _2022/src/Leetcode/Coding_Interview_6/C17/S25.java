package Leetcode.Coding_Interview_6.C17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S25 {
    List<String[]> res = new ArrayList<>();
    int maxSize = 0;

    public String[] maxRectangle(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            int n = word.length();
            if (!map.containsKey(n)) {
                map.put(n, new ArrayList<>());
            }
            map.get(n).add(word);

            insert(word);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> b - a);
        for (int i = 0; i < keys.size(); i++) {
            int n = keys.get(i);
            Node[] pre = new Node[n];
            for (int j = 0; j < n; j++) {
                Node curr = root;
                pre[j] = curr;
            }
            bt(map.get(n), n, new ArrayList<>(), pre);
        }
        int max = 0;
        String[] maxStr = null;
        for (int i = 0; i < res.size(); i++) {
            int count = res.get(i).length * res.get(i)[0].length();
            if (count > max) {
                max = count;
                maxStr = res.get(i);
            }
        }
        return maxStr;
    }

    void bt(List<String> w, int len, List<String> path, Node[] pre) {
        if (path.size() > len) return;
        if (w.size() * w.get(0).length() <= maxSize) return;

        if (isEnd(pre)) {
            String[] strs = new String[path.size()];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = path.get(i);
            }
            maxSize = Math.max(maxSize, strs.length * strs[0].length());
            res.add(strs);
        }

        for (int i = 0; i < w.size(); i++) {
            Node[] curr = extend(pre, w.get(i));
            if (curr == null) continue;
            path.add(w.get(i));
            bt(w, len, path, curr);
            path.remove(path.size() - 1);
        }
    }

    boolean isEnd(Node[] pre) {
        for (int i = 0; i < pre.length; i++) {
            if (!pre[i].isEnd) {
                return false;
            }
        }
        return true;
    }

    Node[] extend(Node[] pre, String s) {
        Node[] curr = new Node[pre.length];
        for (int i = 0; i < pre.length; i++) {
            int idx = s.charAt(i) - 'a';
            if (pre[i].next[idx] == null) return null;
            curr[i] = pre[i].next[idx];
        }
        return curr;
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
}
