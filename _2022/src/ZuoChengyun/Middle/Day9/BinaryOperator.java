package ZuoChengyun.Middle.Day9;

import org.junit.jupiter.api.Test;

public class BinaryOperator {

    //"0&1^0|0&1"
    public static int find(char[] chars, int left, int right, boolean desired) {
        if (left == right) {
            return desired ? (chars[left] == '1' ? 1 : 0) : (chars[left] == '0' ? 1 : 0);
        }

        int count = 0;
        if (desired) {
            for (int i = left + 1; i < right; i += 2) {
                switch (chars[i]) {
                    case '&' -> count += find(chars, left, i - 1, true) * find(chars, i + 1, right, true);
                    case '|' -> {
                        count += find(chars, left, i - 1, true) * find(chars, i + 1, right, true);
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, true);
                        count += find(chars, left, i - 1, true) * find(chars, i + 1, right, false);
                    }
                    case '^' -> {
                        count += find(chars, left, i - 1, true) * find(chars, i + 1, right, false);
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, true);
                    }
                }
            }
        } else {
            for (int i = left + 1; i < right; i += 2) {
                switch (chars[i]) {
                    case '&' -> {
                        count += find(chars, left, i - 1, true) * find(chars, i + 1, right, false);
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, true);
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, false);
                    }
                    case '|' -> {
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, false);
                    }
                    case '^' -> {
                        count += find(chars, left, i - 1, true) * find(chars, i + 1, right, true);
                        count += find(chars, left, i - 1, false) * find(chars, i + 1, right, false);
                    }
                }
            }
        }
        return count;
    }

    public static int findDP(char[] chars, boolean desired) {
        int m = chars.length;
        int[][] dp0 = new int[m][m];
        int[][] dp1 = new int[m][m];

        for (int i = 0; i < m; i += 2) {
            dp0[i][i] = chars[i] == '0' ? 1 : 0;
            dp1[i][i] = chars[i] == '1' ? 1 : 0;
        }

        for (int i = m - 3; i >= 0; i -= 2) {
            for (int j = i + 2; j < m; j += 2) {
                for (int k = i + 1; k < j; k += 2) {
                    switch (chars[k]) {
                        case '&' -> {
                            dp1[i][j] += dp1[i][k - 1] * dp1[k + 1][j];

                            dp0[i][j] += dp1[i][k - 1] * dp0[k + 1][j];
                            dp0[i][j] += dp0[i][k - 1] * dp1[k + 1][j];
                            dp0[i][j] += dp0[i][k - 1] * dp0[k + 1][j];
                        }
                        case '|' -> {
                            dp1[i][j] += dp1[i][k - 1] * dp1[k + 1][j];
                            dp1[i][j] += dp0[i][k - 1] * dp1[k + 1][j];
                            dp1[i][j] += dp1[i][k - 1] * dp0[k + 1][j];

                            dp0[i][j] += dp0[i][k - 1] * dp0[k + 1][j];
                        }
                        case '^' -> {
                            dp1[i][j] += dp1[i][k - 1] * dp0[k + 1][j];
                            dp1[i][j] += dp0[i][k - 1] * dp1[k + 1][j];

                            dp0[i][j] += dp1[i][k - 1] * dp1[k + 1][j];
                            dp0[i][j] += dp0[i][k - 1] * dp0[k + 1][j];
                        }
                    }
                }
            }
        }

        return desired ? dp1[0][m - 1] : dp0[0][m - 1];
    }

    @Test
    void test() {
        String s = "0&1^0|0&1";
        boolean desired = false;

        System.out.println(find(s.toCharArray(), 0, s.length() - 1, desired));

        System.out.println(findDP(s.toCharArray(), desired));
    }
}
