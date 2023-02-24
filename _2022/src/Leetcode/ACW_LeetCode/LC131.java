package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(String s, int idx, List<String> path, List<List<String>> list) {
        if (idx == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (isPal(str)) {
                path.add(str);
                bt(s, i, path, list);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPal(String str) {
        int n = str.length();
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}
