package Leetcode.ACW_LeetCode;

public class LC38 {
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            s = say(s);
            n--;
        }
        return s;
    }

    String say(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            sb.append(j - i).append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
