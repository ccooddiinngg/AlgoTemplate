package ZuoChengyun.Middle.Day2;

import org.junit.jupiter.api.Test;

public class DepthOfParentheses {
    public static int find(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    void test() {
        String s = "(())((()))";
        System.out.println(find(s));
    }
}
