package AC2_Course.KMP;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class KMP {
    public int[] pre(char[] pat) {
        int m = pat.length;
        int[] p = new int[m];
        int i = 1;
        int len = 0;

        while (i < m) {
            if (pat[i] == pat[len]) {
                p[i++] = ++len;
            } else {
                if (len == 0) {
                    p[i++] = 0;
                } else {
                    len = p[len - 1];
                }
            }
        }
        return p;
    }

    public List<Integer> find(char[] s, char[] pat) {
        int[] p = pre(pat);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < s.length) {
            if (s[i] == pat[j]) {
                i++;
                j++;
                if (j == pat.length) {
                    list.add(i - pat.length);
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

    @Test
    void test() throws FileNotFoundException {
        char[] s = "abababa".toCharArray();
        char[] pat = "ababa".toCharArray();

//        char[] s = new Scanner(new File("src/ZuoChengyun/BasicPlus/Day2/kmpSample.txt")).next().toCharArray();
//        char[] pat = ".qwer.".toCharArray();
        System.out.println(find(s, pat));
    }
}
