package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RotateString {
    public static int find(String s, String pat) {
        int[] pre = getPre(pat);
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) {
                    return i - j;
                }
            } else {
                if (j != 0) {
                    j = pre[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    //KMP s1 += s1 , find if s2 is substring of s1
    private static int[] getPre(String pat) {
        int[] pre = new int[pat.length()];
        pre[0] = 0;
        int p = 0;
        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(p)) {
                pre[i++] = ++p;
            } else {
                if (p != 0) {
                    p = pre[p - 1];
                } else {
                    pre[i++] = p;
                }
            }
        }
        return pre;
    }

    //from Geeks
    int[] computeLPSArray(String pat) {
        int M = pat.length();
        // length of the previous longest prefix suffix
        int[] lps = new int[M];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    //from Geeks
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern

        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    @Test
    void test() {
        String s = "12345";
        String pat = "45123";

        System.out.println(Arrays.toString(getPre(pat)));
        System.out.println(find(s + s, pat));
    }
}
