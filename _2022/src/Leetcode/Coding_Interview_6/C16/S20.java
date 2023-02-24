package Leetcode.Coding_Interview_6.C16;

import java.util.ArrayList;
import java.util.List;

public class S20 {
    public List<String> getValidT9Words(String num, String[] words) {
        char[] digits = "22233344455566677778889999".toCharArray();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean match = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (digits[words[i].charAt(j) - 'a'] != num.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(words[i]);
            }
        }
        return list;
    }
}
