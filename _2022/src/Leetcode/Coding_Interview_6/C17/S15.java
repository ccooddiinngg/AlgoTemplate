package Leetcode.Coding_Interview_6.C17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S15 {
    Set<String> set = new HashSet<>();

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        for (String str : words) {
            set.add(str);
        }

        String ans = "";
        for (String str : words) {
            set.remove(str);
            if (find(str, 0)) {
                ans = str;
                break;
            }
            set.add(str);
        }
        return ans;
    }

    boolean find(String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        for (int i = idx + 1; i <= word.length(); i++) {
            String sub = word.substring(idx, i);
            if (set.contains(sub)) {
                if (find(word, i)) return true;
            }
        }
        return false;
    }
}
