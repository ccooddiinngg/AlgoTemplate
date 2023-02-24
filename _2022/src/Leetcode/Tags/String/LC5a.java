package Leetcode.Tags.String;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC5a {
    public String longestPalindrome(String s) {
        //1 整理字符串
        //2 初始化R C r[]
        //3 遍历i
        //4 i > R 正常扩
        //5 找到mirro i1
        //6 r[i1] == R 从R开始kuo
        //7 r[i] = min(R-C, r[i1])

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append('#');
        System.out.println(sb);

        int R = -1;
        int C = -1;
        int[] radius = new int[sb.length()];

        for (int i = 0; i < sb.length(); i++) {
            if (i > R) {
                int r = extend(sb, i, i);
                radius[i] = r;
                R = i + r;
                C = i;
            } else {
                int i1 = C - (i - C);
                if (i1 - radius[i1] == C - (R - C)) {
                    int r = extend(sb, i, R);
                    radius[i] = r;
                    R = i + r;
                    C = i;
                } else {
                    //! R-i
                    radius[i] = Math.min(radius[i1], (R - i));
                }
            }
        }

        int c = -1;
        for (int i = 0; i < radius.length; i++) {
            if (c == -1 || radius[i] > radius[c]) {
                c = i;
            }
        }
        System.out.println(Arrays.toString(radius));
        return sb.substring(c - radius[c], c + radius[c] + 1).replace("#", "");
    }

    int extend(StringBuilder sb, int i, int j) {
        while (j < sb.length() && (i - (j - i) >= 0) && sb.charAt(j) == sb.charAt(i - (j - i))) {
            j++;
        }

        //! -1
        return j - i - 1;
    }

    @Test
    void test() {
        String s = "babad";
        String s1 = "a";
        String s2 = "abbbbc";
        String s3 = "cbbd";
        String s4 = "babadada";

        System.out.println(longestPalindrome(s4));
    }
}
