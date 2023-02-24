package Leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int[] max = new int[]{0, Integer.MAX_VALUE};
        int match = 0;
        Map<Character, Integer> count = new HashMap<>();
        int l = -1;
        int r = 0;
        while (r < s.length()) {
            char cr = s.charAt(r);
            count.put(cr, count.getOrDefault(cr, 0) + 1);
            if (map.containsKey(cr) && count.get(cr).equals(map.get(cr))) {
                match++;
            }
            if (match == map.size()) {
                while (l < r) {
                    char cl = s.charAt(++l);
                    count.put(cl, count.get(cl) - 1);
                    if (map.containsKey(cl) && count.get(cl) < map.get(cl)) {
                        match--;
                    }
                    if (match < map.size()) {
                        break;
                    }
                }
                if (r + 1 - l < max[1] - max[0]) {
                    max[0] = l;
                    max[1] = r + 1;
                }
            }
            r++;
        }
        if (max[1] == Integer.MAX_VALUE) return "";
        return s.substring(max[0], max[1]);
    }

    @Test
    void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
