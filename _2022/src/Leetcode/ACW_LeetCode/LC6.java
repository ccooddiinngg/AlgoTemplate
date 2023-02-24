package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int idx = 0;
        int delta = 1;
        for (char c : s.toCharArray()) {
            list.get(idx).append(c);
            idx += delta;
            if (idx == numRows - 1 || idx == 0) {
                delta = -delta;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}