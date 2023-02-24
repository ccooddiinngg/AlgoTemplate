package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class FIndAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        int m = s.length();
        int n = p.length();
        for (int i = 0; i < n; i++) {
            map[p.charAt(i) - 'a']++;
        }

        int[] arr = new int[26];
        int l = 0;
        int r = 0;
        while (r < n) {
            arr[s.charAt(r) - 'a']++;
            r++;
        }
        List<Integer> list = new LinkedList<>();
        while (r <= m) {
            if (equals(arr, map)) {
                list.add(l);
            }
            if (r == m) break;
            arr[s.charAt(r) - 'a']++;
            arr[s.charAt(l) - 'a']--;
            r++;
            l++;
        }
        return list;
    }

    public boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
