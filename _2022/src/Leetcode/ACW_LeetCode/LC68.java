package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<List<String>> list = new ArrayList<>();
        int idx = 0;
        while (idx < n) {
            List<String> temp = new ArrayList<>();
            int rest = maxWidth;
            int space = 0;
            while (idx < words.length && rest - space >= words[idx].length()) {
                temp.add(words[idx]);
                rest -= words[idx].length();
                space++;
                idx++;
            }
            list.add(temp);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            String s = print(list.get(i), maxWidth);
            ans.add(s);
        }
        String lastLine = printLast(list.get(list.size() - 1), maxWidth);
        ans.add(lastLine);
        return ans;
    }

    String printLast(List<String> list, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(" ");
        }
        sb.append(list.get(list.size() - 1));
        while (sb.length() < maxWidth) sb.append(" ");
        return sb.toString();
    }

    String print(List<String> list, int maxWidth) {
        int n = list.size();
        int spaces = maxWidth;
        for (String str: list) {
            spaces -= str.length();
        }
        int cnt = n == 1? 1:n - 1;
        StringBuilder[] count = new StringBuilder[cnt];
        for (int i = 0; i < count.length; i++) {
            count[i] = new StringBuilder();
            for (int j = 0; j < spaces / cnt; j++) {
                count[i].append(" ");
            }
        }
        for (int i = 0; i < spaces % cnt; i++) {
            count[i].append(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < count.length) {
                sb.append(count[i]);
            }
        }
        return sb.toString();
    }
}
