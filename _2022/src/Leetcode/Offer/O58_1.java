package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class O58_1 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        int n = strs.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!strs[i].equals(""))
                list.add(strs[i]);
        }
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append(" ");
        }
        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    @Test
    void test() {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
