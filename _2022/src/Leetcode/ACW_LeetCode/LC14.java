package Leetcode.ACW_LeetCode;

public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < strs[0].length()) {
            char c = strs[0].charAt(idx);
            boolean match = true;
            for (int i = 1; i < strs.length; i++) {
                if (idx == strs[i].length() || strs[i].charAt(idx) != c) {
                    match = false;
                    break;
                }
            }
            if (match) {
                sb.append(c);
                idx++;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
