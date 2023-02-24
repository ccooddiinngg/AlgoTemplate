package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

//@@
public class N343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int o1 = j * (i - j);
                int o2 = dp[i - j] * j;
                max = Math.max(max, Math.max(o1, o2));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /*
    public int integerBreak(int n) {
        return helper(n);
    }
    public int helper(int n) {
        if (n == 1) {
            return 1;
        }
        int max = 0;

        for (int i = 1; i <= n / 2; i++) {
            int o1 = i * (n - i);
            int o2 = helper(n - i) * i;
            max = Math.max(max, Math.max(o1, o2));
        }
        return max;
    }
    */

    public int integerBreakMath(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        if (n % 3 == 0) {
            int x = n / 3;
            return (int) Math.pow(3, x);
        }
        if (n % 3 == 1) {
            int x = (n - 4) / 3;
            return (int) Math.pow(3, x) * 4;
        }

        int x = (n - 2) / 3;
        return (int) Math.pow(3, x) * 2;

    }

    @Test
    void test() {
        int n = 14;
        System.out.println(integerBreak(n));
        System.out.println(integerBreakMath(n));
    }
}
