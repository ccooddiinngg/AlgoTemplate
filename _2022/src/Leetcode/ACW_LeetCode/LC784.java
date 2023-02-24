package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC784 {
    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        bt(s, 0, new StringBuilder());
        return list;
    }

    List<String> list;

    void bt(String s, int idx, StringBuilder path) {
        if (idx == s.length()) {
            list.add(path.toString());
            return;
        }
        char c = s.charAt(idx);
        if (Character.isLetter(c)) {
            path.append(Character.toLowerCase(c));
            bt(s, idx + 1, path);
            path.setLength(path.length() - 1);
            path.append(Character.toUpperCase(c));
            bt(s, idx + 1, path);
            path.setLength(path.length() - 1);
        } else {
            path.append(c);
            bt(s, idx + 1, path);
            path.setLength(path.length() - 1);
        }

    }
}
