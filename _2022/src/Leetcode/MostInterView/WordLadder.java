package Leetcode.MostInterView;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, Set<String>> nei = buildGraph(wordList);
        Set<String> visited = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.pollFirst();
                visited.add(curr);

                if (curr.equals(endWord)) {
                    return level;
                }

                for (String n : nei.get(curr)) {
                    if (!visited.contains(n)) {
                        q.add(n);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static Map<String, Set<String>> buildGraph(List<String> list) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                chars[i] = '*';
                String pat = String.valueOf(chars);
                if (!map.containsKey(pat)) {
                    map.put(pat, new HashSet<>());
                }
                map.get(pat).add(s);
            }
        }
        Map<String, Set<String>> nei = new HashMap<>();
        for (String s : list) {
            nei.put(s, new HashSet<>());
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                chars[i] = '*';
                String pat = String.valueOf(chars);
                for (String n : map.get(pat)) {
                    nei.get(s).add(n);
                }
            }
        }
        return nei;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
