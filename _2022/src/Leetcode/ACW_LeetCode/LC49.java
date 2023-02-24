package Leetcode.ACW_LeetCode;

import java.util.*;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }

    String getKey(String s) {
        int[] map = new int[26];
        for (char c: s.toCharArray()) {
            map[c - 'a']++;
        }
        return Arrays.toString(map);
    }
}
