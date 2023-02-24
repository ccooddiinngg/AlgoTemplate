package Leetcode.Tags.String;

import org.junit.jupiter.api.Test;

public class LC5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < chars.length) {
            sb.append('#').append(chars[idx++]);
        }
        sb.append('#');

        int n = sb.length();
        int[] radius = new int[n];
        int R = -1;
        int C = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (i > R) { //以i为中心从i开始扩展
                int r = getRadius(sb, i, i);
                R = i + r;
                C = i;
                radius[i] = r;
            } else {
                int i1 = C - (i - C); //找到镜像点
                if (i1 - radius[i1] > (C - (R - C))) { //i1的左边界在C 的左边界内，取i1的半径
                    radius[i] = radius[i1];
                } else if (i1 - radius[i1] == (C - (R - C))) { //i1的左边界在C 的左边界上，以i为中心从R 开始扩展
                    int r = getRadius(sb, i, R);
                    R = i + r;
                    C = i;
                    radius[i] = r;
                } else { //i1的左边界在C 的左边界外，取最大为R的半径
                    radius[i] = R - i;
                }
            }
//            System.out.println(R + " " + C + " " + i);
        }
        int max = 0;
        int center = -1;
        for (int i = 0; i < radius.length; i++) {
            if (radius[i] > max) {
                max = radius[i];
                center = i;
            }
        }
        return sb.substring(center - radius[center], center + radius[center] + 1).replace("#", "");
    }

    int getRadius(StringBuilder sb, int center, int len) {
        while (len < sb.length() && (center - (len - center)) >= 0 && sb.charAt(len) == sb.charAt(center - (len - center))) {
            len++;
        }
        return len - 1 - center;
    }

    @Test
    void test() {
        String s = "babad";
        String s1 = "a";
        String s2 = "abbbbc";

        System.out.println(longestPalindrome(s2));
    }
}
