package tag.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }

        int[] count = new int[26];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            int idx = s.charAt(j) - 'a';
            if (map[idx] == 0) {
                count = new int[26];
                j++;
                i = j;
            } else {
                count[idx]++;
                while (count[idx] > map[idx]) {
                    int index = s.charAt(i) - 'a';
                    count[index]--;
                    i++;
                }
                if (j == i + p.length() - 1) {
                    list.add(i);
                }
                j++;
            }
        }
        return list;
    }
}
