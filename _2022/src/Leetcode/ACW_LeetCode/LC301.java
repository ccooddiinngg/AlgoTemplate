package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
        }
        int max = Math.min(left, right);
        bt(s, 0, max, 0, "", set);
        return new ArrayList<>(set);
    }

    int len = 0;

    //count: '(' = 1, ')' = -1; max: max count
    void bt(String s, int idx, int max, int count, String path, Set<String> set) {
        if (count < 0 || count > max) return;
        if (idx == s.length()) {
            if (count == 0) {
                if (path.length() > len) {
                    set.clear();
                    len = path.length();
                }
                if (path.length() == len) {
                    set.add(path);
                }
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            bt(s, idx + 1, max, count + 1, path + c, set);
            bt(s, idx + 1, max, count, path, set);
        } else if (c == ')') {
            bt(s, idx + 1, max, count - 1, path + c, set);
            bt(s, idx + 1, max, count, path, set);
        } else {
            bt(s, idx + 1, max, count, path + c, set);
        }
    }
}
