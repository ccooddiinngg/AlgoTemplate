package tag.BreadthFirstSearch;

import java.util.*;

//Todo TLE
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //*it -> {hit, ...}
        Map<String, Set<String>> map1 = new HashMap<>();
        //hit -> {*it, h*t, hi*}
        Map<String, Set<String>> map2 = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            map2.putIfAbsent(word, new HashSet<>());
            String[] keys = getKeys(word);
            for (String key : keys) {
                map1.putIfAbsent(key, new HashSet<>());
                map1.get(key).add(word);
                map2.get(word).add(key);
            }
        }
        Map<String, String> path = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> set = new HashSet<>();
        set.add(beginWord);

        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> level = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String key : map2.get(curr)) {
                    if (map1.containsKey(key)) {
                        for (String nei : map1.get(key)) {
                            if (!set.contains(nei)) {
                                path.put(nei, curr);
                                if (endWord.equals(nei)) {
                                    list.add(getPath(path, endWord));
                                    found = true;
                                } else {
                                    level.add(nei);
                                    q.offer(nei);
                                }
                            }
                        }
                    }
                }
            }
            set.addAll(level);
        }
        return list;
    }

    List<String> getPath(Map<String, String> path, String endWord) {
        List<String> list = new ArrayList<>();
        while (endWord != null) {
            list.add(0, endWord);
            endWord = path.get(endWord);
        }
        return list;
    }

    String[] getKeys(String word) {
        String[] res = new String[word.length()];
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            chars[i] = '*';
            res[i] = new String(chars);
            chars[i] = t;
        }
        return res;
    }
}
