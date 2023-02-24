package Leetcode.Coding_Interview_6.C17;

import java.util.*;

public class S22 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>(wordList);
        list.add(beginWord);
        for (int i = 0; i < list.size(); i++) {
            String si = list.get(i);
            if (!map.containsKey(si)) {
                map.put(si, new ArrayList<>());
            }
            for (int j = i + 1; j < list.size(); j++) {
                String sj = list.get(j);
                if (isValid(si, sj)) {
                    map.get(si).add(sj);
                    if (!map.containsKey(sj)) {
                        map.put(sj, new ArrayList<>());
                    }
                    map.get(sj).add(si);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> pre = new HashMap<>();
        q.add(endWord);
        visited.add(endWord);
        pre.put(endWord, null);

        boolean found = false;
        while (!q.isEmpty()) {
            String curr = q.poll();
            //!don't use == , use equals
            if (curr.equals(beginWord)) {
                found = true;
                break;
            }
            for (String next : map.get(curr)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                    pre.put(next, curr);
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (!found) return res;
        String p = beginWord;
        while (p != null) {
            res.add(p);
            p = pre.get(p);
        }
        return res;
    }

    boolean isValid(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return true;
    }
}
