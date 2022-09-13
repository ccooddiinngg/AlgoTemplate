import java.util.ArrayList;
import java.util.List;

public class KMP {
    public static List<Integer> kmp(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] pre = helper(p);
        int m = s.length(), n = p.length();
        int i = 0, j = 0;
        while (i < m) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    list.add(i - j);
                    j = pre[j - 1];
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = pre[j - 1];
                }
            }
        }
        return list;
    }

    private static int[] helper(String p) {
        int n = p.length();
        int[] pre = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (p.charAt(i) == p.charAt(len)) {
                pre[i++] = ++len;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = pre[len - 1];
                }
            }
        }
        return pre;

    }
}
