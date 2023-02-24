package ZuoChengyun.Middle.Day3;

import org.junit.jupiter.api.Test;

public class Decoding {
    public static int count(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') return 0;
        int v1 = 0;
        int v2 = 0;
        v1 += count(s, index + 1);
        if ("12".indexOf(s.charAt(index)) >= 0
                && index + 1 < s.length()
                && "0123456".indexOf(s.charAt(index + 1)) >= 0) {
            v2 += count(s, index + 2);
        }
        return v1 + v2;
    }

    private char decode(String num) {
        int x = Integer.parseInt(num);
        return (char) ('a' + x - 1);
    }

    public static int countDP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i + 1];
                if ("12".indexOf(s.charAt(i)) >= 0
                        && "0123456".indexOf(s.charAt(i + 1)) >= 0) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    @Test
    void test() {
        String s = "12258";
        System.out.println(count(s, 0));
        System.out.println(countDP(s));
    }
}
