package tag.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> count = new HashMap<>();
        int match = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
            //compare two Integers
            if (map.containsKey(c) && count.get(c).intValue() == map.get(c).intValue()) {
                match++;
                if (match == map.size()) {
                    while (j <= i) {
                        char cj = s.charAt(j);
                        count.put(cj, count.get(cj) - 1);
                        if (map.containsKey(cj) && count.get(cj) < map.get(cj)) {
                            match--;
                        }
                        j++;
                        if (match < map.size()) {
                            int len = i - j + 2;
                            if (len < min) {
                                min = len;
                                res = s.substring(j - 1, i + 1);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
