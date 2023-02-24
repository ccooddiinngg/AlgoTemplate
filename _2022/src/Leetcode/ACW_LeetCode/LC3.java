package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int idx = map.get(s.charAt(j));
                while (i <= idx) {
                    map.remove(s.charAt(i));
                    i++;
                }
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}