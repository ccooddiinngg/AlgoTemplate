package tag.DynamicProgramming;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return bt(s.toCharArray(), 0);
    }

    int[] cache;

    int bt(char[] chars, int idx) {
        if (idx == chars.length) {
            return 1;
        }
        if (cache[idx] != -1) return cache[idx];
        int way = 0;
        if (chars[idx] != '0') {
            way += bt(chars, idx + 1);
            if (idx < chars.length - 1) {
                int d1 = chars[idx] - '0';
                int d2 = chars[idx + 1] - '0';
                if (d1 == 1 || (d1 == 2 && d2 <= 6)) {
                    way += bt(chars, idx + 2);
                }
            }
        }
        cache[idx] = way;
        return way;
    }
}
