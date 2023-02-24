package Leetcode.Coding_Interview_6.C17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S17 {
    public int[][] multiSearch(String big, String[] smalls) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String str : smalls) {
            map.put(str, new ArrayList<>());
            insert(str);
        }
        int n = big.length();
        for (int i = 0; i < n; i++) {
            Node curr = root;
            for (int j = i; j < n; j++) {
                int idx = big.charAt(j) - 'a';
                if (curr.next[idx] == null) break;
                String str = curr.next[idx].str;
                if (!str.equals("")) {
                    map.get(str).add(i);
                }
                curr = curr.next[idx];
            }
        }
        int[][] res = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> values = map.get(smalls[i]);
            int[] indices = new int[values.size()];
            for (int j = 0; j < indices.length; j++) {
                indices[j] = values.get(j);
            }
            res[i] = indices;
        }
        return res;
    }

    Node root = new Node();

    class Node {
        Node[] next = new Node[26];
        String str = "";
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
        curr.str = s;
    }
}
