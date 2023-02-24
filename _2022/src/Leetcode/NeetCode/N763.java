package Leetcode.NeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a'] = Math.max(map[chars[i] - 'a'], i);
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < chars.length) {
            int j = map[chars[i] - 'a'];
            int k = i + 1;
            while (k < j) {
                j = Math.max(map[chars[k] - 'a'], j);
                k++;
            }
            list.add(j - i + 1);
            i = j + 1;
        }
        return list;
    }
}
