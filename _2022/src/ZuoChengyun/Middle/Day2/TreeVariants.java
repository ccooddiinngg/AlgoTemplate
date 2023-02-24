package ZuoChengyun.Middle.Day2;

import org.junit.jupiter.api.Test;

public class TreeVariants {
    public static int find(int rest) {
        if (rest == 0) return 1;
        int v = 0;
        for (int i = 0; i <= rest - 1; i++) {
            v += find(i) * find(rest - 1 - i);
        }
        return v;
    }

    public static int findDP(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[N];
    }

    @Test
    void test() {
        int N = 19;
//        System.out.println(find(N));
        System.out.println(findDP(N));
    }
}
