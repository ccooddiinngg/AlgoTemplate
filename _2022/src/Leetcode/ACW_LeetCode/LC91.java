package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC91 {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return bt(s.toCharArray(), 0, cache);
    }

    int bt(char[] chars, int idx, int[] cache) {
        if (idx == chars.length) return 1;
        if (chars[idx] == '0') return 0;
        if (cache[idx] != -1) return cache[idx];
        int op = 0;
        op += bt(chars, idx + 1, cache);
        if (idx < chars.length - 1 && (chars[idx] == '1' || (chars[idx] == '2' && chars[idx + 1] - '0' <= 6))) {
            op += bt(chars, idx + 2, cache);
        }
        cache[idx] = op;
        return op;
    }
}
