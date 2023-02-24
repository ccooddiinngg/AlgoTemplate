package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC132 {
    public int minCut(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);

        //! first cut doesn't count
        return bt(s, 0, cache) - 1;
    }

    int bt(String s, int idx, int[] cache) {
        if (idx == s.length()) return 0;
        if (cache[idx] != -1) return cache[idx];
        int next = Integer.MAX_VALUE;
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (isPal(str)) {
                next = Math.min(next, bt(s, i, cache));
            }
        }
        // System.out.println(idx + " " + next);
        int res = next == Integer.MAX_VALUE ? Integer.MAX_VALUE : next + 1;
        cache[idx] = res;
        return res;
    }

    boolean isPal(String str) {
        int n = str.length();
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    @Test
    void test() {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
