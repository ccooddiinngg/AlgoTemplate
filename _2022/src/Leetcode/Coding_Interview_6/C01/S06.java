package Leetcode.Coding_Interview_6.C01;

public class S06 {
    public String compressString(String S) {
        int m = S.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < m && j < m) {
            sb.append(S.charAt(i));
            while (j < m && S.charAt(j) == S.charAt(i)) j++;
            sb.append(j - i);
            i = j;
            j = i;
        }
        String res = sb.toString();
        return res.length() >= m ? S : res;
    }
}
