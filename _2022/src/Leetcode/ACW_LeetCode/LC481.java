package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC481 {
    public int magicalString(int n) {
        String[][] str = {{"1", "11"}, {"2", "22"}};
        StringBuilder sb = new StringBuilder();
        sb.append("122");
        int idx = 2;
        int flag = 0;
        while (sb.length() < n) {
            int k = Integer.parseInt(String.valueOf(sb.charAt(idx)));
            sb.append(str[flag][k - 1]);
            idx++;
            flag = 1 - flag;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') count++;
        }
        return count;
    }

    @Test
    void test() {
        //1 22 11 2 1 22 1 22 11 2 11 22
        int n = 16;
        System.out.println(magicalString(n));
    }
}
