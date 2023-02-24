package Leetcode.Coding_Interview_6.C01;

public class S09 {
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m == 0 && n == 0) return true;
        if (m != n) return false;
        int i = 0;
        while (i < m) {
            if (s1.charAt(i) != s2.charAt(0)) {
                i++;
            } else {
                int i1 = i;
                int j1 = 0;
                while (i1 < m && j1 < n && s1.charAt(i1) == s2.charAt(j1)) {
                    i1 = (i1 + 1) % m;
                    j1++;
                    if (j1 == n) {
                        return true;
                    }
                }
                i++;
            }
        }
        return false;
    }
}
