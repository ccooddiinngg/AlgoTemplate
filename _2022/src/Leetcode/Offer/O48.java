package Leetcode.Offer;

import java.util.HashMap;
import java.util.Map;

public class O48 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(chars[i])) {
                int idx = map.get(chars[i]);
                while (j <= idx) {
                    map.remove(chars[j++]);
                }
            }
            map.put(chars[i], i);
            max = Math.max(max, i - j + 1);

        }
        return max;
    }
}
