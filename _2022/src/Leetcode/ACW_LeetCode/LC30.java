package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int n = words[0].length();
        int len = n * words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - len; i++) {
            if (find(s.substring(i, i + len), n, new HashMap<>(map)) && !list.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    boolean find(String str, int n, Map<String, Integer> map) {
        int i = 0;
        while (i < str.length()) {
            String key = str.substring(i, i + n);
            if (!map.containsKey(key)) return false;
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) map.remove(key);
            i += n;
        }
        return true;
    }

    @Test
    void test() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }
}
