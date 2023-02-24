package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301a {
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
        //number of '(' or ')'should be removed
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        //length of result
        int len = s.length() - l - r;
        
        int max = Math.min(left, right);
        bt(s, 0, max, 0, len, l, r, "", set);
        return new ArrayList<>(set);
    }

    //count: '(' = 1, ')' = -1; max: max count
    void bt(String s, int idx, int max, int count, int len, int l, int r, String path, Set<String> set) {
        if (count < 0 || count > max || l < 0 || r < 0) return;
        if (idx == s.length()) {
            if (count == 0 && path.length() == len) {
                set.add(path);
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            bt(s, idx + 1, max, count + 1, len, l, r, path + c, set);
            bt(s, idx + 1, max, count, len, l - 1, r, path, set);
        } else if (c == ')') {
            bt(s, idx + 1, max, count - 1, len, l, r, path + c, set);
            bt(s, idx + 1, max, count, len, l, r - 1, path, set);
        } else {
            bt(s, idx + 1, max, count, len, l, r, path + c, set);
        }
    }
}
