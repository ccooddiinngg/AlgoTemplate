package Playground.KMP;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    public List<Integer> kmp(String s, String pat) {
        int[] p = pre(pat);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < s.length()) {
            if (s.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) {
                    list.add(i - j);
                    j = p[j - 1];
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = p[j - 1];
                }
            }
        }
        return list;
    }

    private int[] pre(String pat) {
        int n = pat.length();
        int[] p = new int[n];
        int len = 0;
        int idx = 1;
        while (idx < n) {
            if (pat.charAt(idx) == pat.charAt(len)) {
                p[idx++] = ++len;
            } else {
                if (len == 0) {
                    idx++;
                } else {
                    len = p[len - 1];
                }
            }
        }
        return p;
    }
}
