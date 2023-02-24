package ZuoChengyun.BasicPlus.Day2;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KMP {

    public static int[] prefix(String t) {
        if (t == null || t.length() < 2) {
            return null;
        }
        int[] pre = new int[t.length()];
        pre[0] = -1;
        pre[1] = 0;
        int index = 0;
        int i = 2;
        while (i < pre.length) {
            while (index >= 0 && t.charAt(i - 1) != t.charAt(index)) {
                index = pre[index];
            }
            pre[i++] = ++index;
        }
        return pre;
    }

    public static int kmp(String s, String t, int[] tPrefix) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return -1;
        }
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            while (j >= 0 && s.charAt(i) != t.charAt(j)) {
                j = tPrefix[j];
            }
            i++;
            j++;
        }
        if (j == n) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int bruteForce(String text, String pat) {
        int m = text.length();
        int n = pat.length();
        if (n > m) {
            return -1;
        }
        for (int i = 0; i < m; i++) {
            int i1 = i;
            int j = 0;
            while (j < n && text.charAt(i1) == pat.charAt(j)) {
                i1++;
                j++;
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    @RepeatedTest(10)
    void test() {
        String s = Utils.generateRandomAlphabeticString(10);

        String t = s.substring(5, 9);

        System.out.println(s);
        System.out.println(t);

        int[] prefix = prefix(t);
        int kmp = kmp(s, t, prefix);
        System.out.println(Arrays.toString(prefix));
        System.out.println(kmp);

        int bf = bruteForce(s, t);
        System.out.println(bf);
        assertEquals(bf, kmp);
    }

    @Test
    void test1() {
        String text = Utils.readFile("src/ZuoChengyun/BasicPlus/Day2/kmpSample.txt");
        String pat = ".qwer.";
        assert text != null;
        int kmp = kmp(text, pat, prefix(pat));
        int bf = bruteForce(text, pat);
        System.out.println(kmp);
        System.out.println(bf);
    }
}
