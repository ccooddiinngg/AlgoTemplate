package String;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    public int[] pre(String pat) {
        int[] p = new int[pat.length()];
        int len = 0;
        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                p[i++] = ++len;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = p[len - 1];
                }
            }
        }
        return p;
    }

    public List<Integer> kmp(String s, String pat) {
        int[] p = pre(pat);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) {
                    list.add(i - j);
                    j = p[j - 1];
                }
            } else {
                if (p[j] == 0) {
                    i++;
                } else {
                    j = p[j - 1];
                }
            }
        }
        return list;
    }
}
