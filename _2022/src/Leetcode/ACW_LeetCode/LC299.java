package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC299 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        boolean[] used = new boolean[n];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < n; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
                used[i] = true;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                char c = secret.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                char c = guess.charAt(i);
                if (map.containsKey(c) && map.get(c) > 0) {
                    cow++;
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}
