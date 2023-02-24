package Leetcode.NeetCode;

import java.util.ArrayList;
import java.util.List;

public class N438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (n > m) {
            return list;
        }

        int[] map = getMap(p);
        int[] window = new int[26];
        char[] sArray = s.toCharArray();

        int i = -1;
        int j = -1;
        while (j < n - 1) {
            j++;
            window[sArray[j] - 'a']++;
        }

        if (equals(map, window)) {
            list.add(i + 1);
        }

        while (j < m - 1) {
            j++;
            window[sArray[j] - 'a']++;
            i++;
            window[sArray[i] - 'a']--;
            if (equals(map, window)) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getMap(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
