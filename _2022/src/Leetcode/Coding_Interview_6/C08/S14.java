package Leetcode.Coding_Interview_6.C08;

public class S14 {
    public int countEval(String s, int result) {
        int n = s.length();
        P[][] cache = new P[n][n];
        P res = helper(s.toCharArray(), n, 0, n - 1, cache);
        return result == 0 ? res.low : res.high;
    }

    P helper(char[] chars, int n, int l, int r, P[][] cache) {
        if (l == r) {
            int v = Integer.parseInt(String.valueOf(chars[l]));
            return v == 1 ? new P(0, 1) : new P(1, 0);
        }
        if (cache[l][r] != null) return cache[l][r];

        P res = new P(0, 0);
        for (int i = l + 1; i < r; i += 2) {
            P left = helper(chars, n, l, i - 1, cache);
            P right = helper(chars, n, i + 1, r, cache);
            if (chars[i] == '&') {
                res.high += left.high * right.high;
                res.low += left.low * right.high + left.high * right.low + left.low * right.low;
            }
            if (chars[i] == '|') {
                res.high += left.high * right.low + left.low * right.high + left.high * right.high;
                res.low += left.low * right.low;
            }
            if (chars[i] == '^') {
                res.high += left.high * right.low + left.low * right.high;
                res.low += left.low * right.low + left.high * right.high;
            }
        }
        cache[l][r] = new P(res.low, res.high);
        return res;
    }

    class P {
        //结果为0的个数
        int low;
        //结果为1的个数
        int high;

        public P(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
