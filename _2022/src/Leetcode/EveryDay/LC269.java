package Leetcode.EveryDay;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LC269 {
    Map<Character, List<Character>> map = new HashMap<>();

    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Character, Integer> indegrees = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
            }
        }
        boolean isValid = true;
        for (int i = 0; i < n - 1; i++) {
            String pre = words[i];
            String next = words[i + 1];
            int j = 0;
            while (j < pre.length() && j < next.length()) {
                char c1 = pre.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    map.get(c1).add(c2);
                    indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                    break;
                }
                j++;
            }
            if (pre.length() > next.length() && j == next.length()) {
                isValid = false;
            }
        }
        if (!isValid) return "";

        Queue<Character> q = new LinkedList<>();
        for (char c : map.keySet()) {
            if (!indegrees.containsKey(c)) {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            if (map.containsKey(curr)) {
                for (char c : map.get(curr)) {
                    if (indegrees.containsKey(c)) {
                        indegrees.put(c, indegrees.get(c) - 1);
                        if (indegrees.get(c) == 0) {
                            indegrees.remove(c);
                            q.offer(c);
                        }
                    }
                }
            }
        }
        //如果每个节点都加入了结果，表示无环
        if (sb.length() == map.size()) {
            return sb.toString();
        } else {
            return "";
        }
    }

    @Test
    void test() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words2 = {"z", "z"};
        String[] words3 = {"wrt", "wrtkj"};

        //有环：只会加入b
        String[] words4 = {"z", "x", "a", "zb", "zx"};
        System.out.println(alienOrder(words4));
    }
}
