package Leetcode.Coding_Interview_6.C01;

public class S03 {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        String str = "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append(str);
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
