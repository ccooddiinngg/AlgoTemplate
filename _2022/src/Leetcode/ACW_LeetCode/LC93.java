package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        bt(s.toCharArray(), 0, new ArrayList<>(), list);
        return list;
    }

    void bt(char[] chars, int idx, List<Integer> path, List<String> list) {
        if (idx == chars.length) {
            if (path.size() == 4) {
                String str = toString(path);
                list.add(str);
            }
            return;
        }
        if (idx > chars.length || path.size() == 4) return;
        path.add(getValue(chars, idx, 1));
        bt(chars, idx + 1, path, list);
        path.remove(path.size() - 1);

        if (chars[idx] != '0') {
            if (idx < chars.length - 1) {
                path.add(getValue(chars, idx, 2));
                bt(chars, idx + 2, path, list);
                path.remove(path.size() - 1);
            }
            if (idx < chars.length - 2) {
                int val = getValue(chars, idx, 3);
                if (val <= 255) {
                    path.add(val);
                    bt(chars, idx + 3, path, list);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    int getValue(char[] chars, int idx, int len) {
        int res = 0;
        for (int i = idx; i < idx + len; i++) {
            res = res * 10 + chars[i] - '0';
        }
        return res;
    }

    String toString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int p: path) {
            sb.append(p).append(".");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
