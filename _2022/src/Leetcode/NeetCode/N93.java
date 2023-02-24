package Leetcode.NeetCode;

import java.util.ArrayList;
import java.util.List;

public class N93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, 4, new StringBuilder(), list);
        return list;
    }

    public void helper(String s, int index, int dot, StringBuilder path, List<String> list) {
        if (dot < 0 || index > s.length()) {
            return;
        }
        if (dot == 0 && index == s.length()) {
            path.setLength(path.length() - 1);
            list.add(path.toString());
            return;
        }
        if (index <= s.length() - 3 && s.charAt(index) != '0') {
            String s3 = s.substring(index, index + 3);
            if (Integer.parseInt(s3) < 256) {
                StringBuilder sb = new StringBuilder(path);
                sb.append(s3).append(".");
                helper(s, index + 3, dot - 1, sb, list);
            }
        }

        if (index <= s.length() - 2 && s.charAt(index) != '0') {
            String s2 = s.substring(index, index + 2);
            StringBuilder sb = new StringBuilder(path);
            sb.append(s2).append(".");
            helper(s, index + 2, dot - 1, sb, list);
        }

        if (index <= s.length() - 1) {
            String s1 = s.substring(index, index + 1);
            StringBuilder sb = new StringBuilder(path);
            sb.append(s1).append(".");
            helper(s, index + 1, dot - 1, sb, list);
        }
    }
}
