package tag.Graph;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        int[] indegree = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            char[] a = words[i].toCharArray();
            char[] b = words[i + 1].toCharArray();
            int idx = 0;
            while (idx < a.length && idx < b.length) {
                if (a[idx] != b[idx]) {
                    if (!map.get(a[idx]).contains(b[idx])) {
                        map.get(a[idx]).add(b[idx]);
                        indegree[b[idx] - 'a']++;
                    }
                    break;
                }
                idx++;
                if (idx == b.length && idx < a.length) {
                    return "";
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            char c = (char) (i + 'a');
            if (indegree[i] == 0 && map.containsKey(c)) {
                q.offer(c);
            }
        }
        StringBuilder path = new StringBuilder();
        while (!q.isEmpty()) {
            Character c = q.poll();
            path.append(c);
            for (Character nei : map.get(c)) {
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0) {
                    q.offer(nei);
                }
            }
        }
        if (path.length() == map.size()) {
            return path.toString();
        }
        return "";
    }
}
