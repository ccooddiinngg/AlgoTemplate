package tag.DynamicProgramming;

import java.util.Arrays;

public class DecodeWaysII {
    long mod = (long) (1e9 + 7);

    public int numDecodings(String s) {
        cache = new long[s.length()];
        Arrays.fill(cache, -1);
        return (int) bt(s.toCharArray(), 0);
    }

    long[] cache;

    long bt(char[] chars, int idx) {
        if (idx == chars.length) {
            return 1;
        }
        if (cache[idx] != -1) return cache[idx];
        long way = 0;
        if (chars[idx] != '0') {
            if (chars[idx] == '*') {
                way += 9 * bt(chars, idx + 1);
                if (idx < chars.length - 1) {
                    if (chars[idx + 1] == '*') {
                        way += 15 * bt(chars, idx + 2);
                    } else {
                        way += bt(chars, idx + 2);
                        if (chars[idx + 1] - '0' <= 6) {
                            way += bt(chars, idx + 2);
                        }
                    }
                }
            } else {
                way += bt(chars, idx + 1);
                if (idx < chars.length - 1) {
                    if (chars[idx + 1] == '*') {
                        if (chars[idx] == '1') {
                            way += 9 * bt(chars, idx + 2);
                        }
                        if (chars[idx] == '2') {
                            way += 6 * bt(chars, idx + 2);
                        }
                    } else {
                        if (chars[idx] == '1') {
                            way += bt(chars, idx + 2);
                        }
                        if (chars[idx] == '2' && chars[idx + 1] - '0' <= 6) {
                            way += bt(chars, idx + 2);
                        }
                    }
                }
            }

        }
        cache[idx] = way % mod;
        return cache[idx];
    }
}
