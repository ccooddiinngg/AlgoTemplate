package ZuoChengyun.Middle.Day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class LongestParentheses {

    public static int find2(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                int pre = i - 1 - dp[i - 1];
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (pre > 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    @Test
    void test() {
//        String s = "((())(()))()()()))(())(((((((((())(";
        String s = creat();
        System.out.println(s);
        System.out.println(find2(s));
    }

    String creat() {
//        int n = (int) (Math.random() * 100);
        int n = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean r = new Random().nextBoolean();
            if (r) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
