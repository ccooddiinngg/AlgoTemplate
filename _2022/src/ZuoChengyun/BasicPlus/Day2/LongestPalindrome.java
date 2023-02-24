package ZuoChengyun.BasicPlus.Day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindrome {

    public static int longestPalindrome(char[] s) {
        int m = s.length;
        int[] r = new int[m];
        int R = -1;
        int C = -1;
        for (int i = 1; i < m; i++) {
            if (i > R) {
                int radius = extend(s, i, 1);
                r[i] = radius;
                if (radius > R) {
                    R = radius;
                    C = i;
                }
            } else {
                int iMirror = C - (i - C);
                int iMirrorLeftBound = iMirror - r[iMirror];
                int CLeftBound = C - (R + 1) / 2;
                if (iMirrorLeftBound > CLeftBound || iMirrorLeftBound < CLeftBound) {
                    r[i] = r[iMirror];
                } else {
                    int radius = extend(s, i, R - i);
                    r[i] = radius;
                    if (radius > R) {
                        R = radius;
                        C = i;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < r.length; i++) {
            max = Math.max(max, r[i]);
        }
        return max - 1;
    }

    private static int extend(char[] s, int i, int j) {
        int j1 = j;
        while (i + j1 < s.length && i - j1 >= 0 && s[i + j1] == s[i - j1]) {
            j1++;
        }
        return j1;
    }

    public static char[] fill(String s) {
        char[] filled = new char[s.length() * 2 + 1];
        for (int i = 0; i < filled.length; i++) {
            if (i % 2 == 1) {
                filled[i] = s.charAt(i / 2);
            } else {
                filled[i] = '#';
            }
        }
        System.out.println(filled);
        return filled;
    }

    @Test
    void test() {
        String s = "abacabacabb";
        char[] chars = fill(s);
        int count = longestPalindrome(chars);
        System.out.println(count);

        int manachersAlgorithm = manachersAlgorithm(s, s.length());
        assertEquals(count, manachersAlgorithm);
    }


    /*from web*/
    int manachersAlgorithm(String s, int N) {
        String str = getModifiedString(s, N);
        int len = (2 * N) + 1;
        int[] P = new int[len];
        int c = 0; //stores the center of the longest palindromic substring until now
        int r = 0; //stores the right boundary of the longest palindromic substring until now
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;

            //see if the mirror of i is expanding beyond the left boundary of current longest palindrome at center c
            //if it is, then take r - i as P[i]
            //else take P[mirror] as P[i]
            if (i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }

            //expand at i
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }

            //check if the expanded palindrome at i is expanding beyond the right boundary of current longest palindrome at center c
            //if it is, the new center is i
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];

                if (P[i] > maxLen) { //update maxlen
                    maxLen = P[i];
                }
            }
        }
        return maxLen;
    }

    String getModifiedString(String s, int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
}
