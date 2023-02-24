package Leetcode.ACW_LeetCode;

public class LC394a {
    public String decodeString(String s) {
        return f(s, 0)[0];
    }

    //return [0]:next i, [1]: string
    String[] f(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                String[] next = f(s, idx + 1);
                for (int i = 0; i < num; i++) {
                    sb.append(next[1]);
                }
                num = 0;
                idx = Integer.parseInt(next[0]);
            } else {
                return new String[]{String.valueOf(idx), sb.toString()};
            }
            idx++;
        }
        return new String[]{sb.toString()};
    }
}
