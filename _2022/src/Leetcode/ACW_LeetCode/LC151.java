package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC151 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            if (!str.equals(" ") && !str.equals("")) {
                list.add(str);
            }
        }

        // System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
