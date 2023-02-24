package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        buildMap(map, wordList);
        Queue<String> q1 = new LinkedList<>();
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        q1.offer(beginWord);
        Queue<String> q2 = new LinkedList<>();
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        q2.offer(endWord);

        int step = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            for (int i = 0; i < size1; i++) {
                String curr = q1.poll();
                if (set2.contains(curr)) return step;
                for (String nei: map.get(curr)) {
                    if (!set1.contains(nei)) {
                        set1.add(nei);
                        q1.offer(nei);
                    }
                }
            }
            step++;
            int size2 = q2.size();
            for (int i = 0; i < size2; i++) {
                String curr = q2.poll();
                if (set1.contains(curr)) return step;
                for (String nei: map.get(curr)) {
                    if (!set2.contains(nei)) {
                        set2.add(nei);
                        q2.offer(nei);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    void buildMap(Map<String, List<String>> map, List<String> wordList) {
        for (String key: wordList) {
            map.put(key, new ArrayList<>());
            for (String str: wordList) {
                if (isValid(key, str)) {
                    map.get(key).add(str);
                }
            }
        }

    }

    boolean isValid(String s1, String s2) {
        int miss = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) miss++;
            if (miss > 1) return false;
        }
        return true;
    }

    @Test
    void test() {
        String beginWord = "leet";
        String endWord = "code";
        List<String> wordList = new ArrayList<>(List.of("lest","leet","lose","code","lode","robe","lost"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
