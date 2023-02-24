package ZuoChengyun.Middle.Day2;

import org.junit.jupiter.api.Test;

public class CompleteParentheses {
    public static int find(String s) {
        if (s.length() == 0) return 0;
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) {
                res++;
                count = 0;
            }
        }
        return res + count;
    }

    @Test
    void test() {
        String s = ")))(((";
        System.out.println(find(s));
    }
}
