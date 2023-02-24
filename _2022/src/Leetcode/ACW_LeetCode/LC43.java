package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC43 {
    public String multiply(String num1, String num2) {
        String[] n1 = num1.split("");
        String[] n2 = num2.split("");
        int m = n1.length;
        int n = n2.length;
        int[] ans = new int[(m + 1) * (n + 1)];
        Arrays.fill(ans, 0);

        for (int i = m - 1, bit = 0; i >= 0; i--, bit++) {
            int a = Integer.parseInt(n1[i]);
            int[] res = new int[(m + 1) * (n + 1)];
            Arrays.fill(res, 0);
            int carry = 0;
            int pos = bit;
            for (int j = n - 1; j >= 0; j--) {
                int b = Integer.parseInt(n2[j]);
                int c = a * b + carry;
                res[pos++] = (c % 10);
                carry = c / 10;
            }
            if (carry > 0) res[pos] = carry;
            add(ans, res);
        }
        StringBuilder sb = new StringBuilder();
        int idx = ans.length - 1;
        while (idx >= 0 && ans[idx] == 0) idx--;
        if (idx == -1) return "0";
        while (idx >= 0) {
            sb.append(ans[idx--]);
        }
        return sb.toString();
    }

    private void add(int[] ans, int[] res) {
        int carry = 0;
        for (int i = 0; i < ans.length; i++) {
            int a = ans[i];
            int b = res[i];
            int c = a + b + carry;
            ans[i] = (c % 10);
            carry = c / 10;
        }
    }

    @Test
    void test() {
        String num1 = "1434324";
        String num2 = "8842525";
        System.out.println(multiply(num1, num2));
    }
}
