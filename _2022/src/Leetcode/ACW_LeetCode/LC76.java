package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> had = new HashMap<>();

        char[] ct = t.toCharArray();
        for (char c : ct) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int total = need.size();
        int count = 0;

        char[] cs = s.toCharArray();
        int n = cs.length;
        int l = 0;
        int r = 0;
        int max = Integer.MAX_VALUE;
        int[] res = new int[2];
        while (r < n) {
            if (need.containsKey(cs[r])) {
                had.put(cs[r], had.getOrDefault(cs[r], 0) + 1);
                if (had.get(cs[r]).intValue() == need.get(cs[r]).intValue()) count++;
            }
            if (count == total) {
                while (l < n && count == total) {
                    if (had.containsKey(cs[l])) {
                        had.put(cs[l], had.get(cs[l]) - 1);
                        if (had.get(cs[l]).intValue() < need.get(cs[l]).intValue()) count--;
                    }
                    l++;
                }
                if (r - l + 2 < max) {
                    max = r - l + 2;
                    res = new int[] {l - 1, r + 1};
                }
            }
            r++;
        }
        return s.substring(res[0], res[1]);
    }
}
