package AC2.A2;

import java.io.*;

public class A831 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        char[] pat = reader.readLine().toCharArray();
        int m = Integer.parseInt(reader.readLine());
        char[] s = reader.readLine().toCharArray();

        int[] pre = lps(pat);
        int i = 0;
        int j = 0;
        while (i < s.length) {
            if (s[i] == pat[j]) {
                i++;
                j++;
                if (j == pat.length) {
                    writer.write((i - j) + " ");
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
        writer.flush();
        writer.close();
        reader.close();
    }

    static int[] lps(char[] pat) {
        int[] pre = new int[pat.length];
        int len = 0;
        int i = 1;
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                pre[i++] = ++len;
            } else {
                if (len == 0) {
                    pre[i++] = len;
                } else {
                    len = pre[len - 1];
                }
            }
        }
        return pre;
    }
}
