package tag.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length;
        int n = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            slidingWindow(s, m, n, i, map);
        }
        return list;
    }

    List<Integer> list = new ArrayList<>();

    void slidingWindow(String s, int m, int n, int idx, Map<String, Integer> map) {
        Map<String, Integer> count = new HashMap<>();
        int j = idx;
        int i = idx;
        while (j <= s.length() - n) {
            String str = s.substring(j, j + n);
            if (!map.containsKey(str)) {
                j += n;
                i = j;
                count.clear();
            } else {
                count.put(str, count.getOrDefault(str, 0) + 1);
                while (count.get(str) > map.get(str)) {
                    String t = s.substring(i, i + n);
                    count.put(t, count.get(t) - 1);
                    i += n;
                }
                if (j == i + m * n - n) {
                    list.add(i);
                }
                j += n;
            }
        }
    }
}
