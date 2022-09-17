package tag.BreadthFirstSearch;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        //*it -> {hit,...}
        Map<String, List<String>> map1 = new HashMap<>();
        //hit -> {*it, h*t, hi*}
        Map<String, List<String>> map2 = new HashMap<>();
        for (String word : wordList) {
            if (!map2.containsKey(word)) {
                map2.put(word, new ArrayList<>());
            }
            String[] keys = getKeys(word);
            for (String key : keys) {
                if (!map1.containsKey(key)) {
                    map1.put(key, new ArrayList<>());
                }
                map1.get(key).add(word);
                map2.get(word).add(key);
            }
        }

        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.add(beginWord);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (endWord.equals(curr)) {
                    return step;
                }
                for (String key : map2.get(curr)) {
                    if (map1.containsKey(key)) {
                        for (String nei : map1.get(key)) {
                            if (!set.contains(nei)) {
                                set.add(nei);
                                q.offer(nei);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    String[] getKeys(String word) {
        String[] res = new String[word.length()];
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char t = sb.charAt(i);
            sb.setCharAt(i, '*');
            res[i] = sb.toString();
            sb.setCharAt(i, t);
        }
        return res;
    }
}
