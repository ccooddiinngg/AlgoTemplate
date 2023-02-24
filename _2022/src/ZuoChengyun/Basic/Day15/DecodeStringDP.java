package ZuoChengyun.Basic.Day15;

import org.junit.jupiter.api.Test;

public class DecodeStringDP {

    public static int decodeStringDP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            int o1 = 0;
            int o2 = 0;
            if (s.charAt(i) != '0') {
                o1 = dp[i + 1];
            }
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".contains("" + s.charAt(i + 1))))) {
                o2 = dp[i + 2];
            }
            dp[i] = o1 + o2;
        }
        return dp[0];
    }

    private static char digitToLetter(String s) {
        return (char) (Integer.parseInt(s) - 1 + 'A');
    }

    @Test
    void decodeStringDPTest() {
        String s = "11111";
        int n = decodeStringDP(s);
        System.out.println(n);
    }
}
